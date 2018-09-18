package com.brest.test.web_app.controllers;


import com.brest.test.Article;
import com.brest.test.Author;
import com.brest.test.AuthorDto;
import com.brest.test.service.ArticleService;
import com.brest.test.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    ArticleService articleService;

    @GetMapping(value = "/authors")
    public final String departments(Model model) {
//        Collection<Author> authors = authorService.getAllAuthor();
        Collection<AuthorDto> authorDtos = authorService.getAuthorDto();
        model.addAttribute("authors",authorDtos);
        return   "authors";
    }

    //форма для ввода нового автора
    @GetMapping(value = "/author")
    public  String getAddAuthor(Model model){
        model.addAttribute("author", new Author());
        return "author";
    }

    //Добавление нового автора
    @PostMapping (value = "/author")
    public String postAddAuthor(Author author,Model model){
        authorService.addAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping(value = "/author/{id}")
    public  String getEditAuthor(Model model, @PathVariable final int id){
        model.addAttribute("author",authorService.getAuthorById(id));
        return "author";
    }

    @PostMapping(value = "/author/{id}")
    public String postEditAuthor(Model model, Author author){
        authorService.updateAuthor(author);
        return "redirect:/authors";
    }
//  сделать проверку ссылочной целосности
    @GetMapping (value = "author/{id}/delete")
    public String getDeleteAuthor(Model model,@PathVariable final int id){
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
