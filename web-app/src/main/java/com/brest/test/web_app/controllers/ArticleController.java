package com.brest.test.web_app.controllers;

import com.brest.test.Article;
import com.brest.test.ArticleDto;
import com.brest.test.Author;
import com.brest.test.service.ArticleService;
import com.brest.test.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * Article controller.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    AuthorService authorService;

    @GetMapping (value = "/articles")
    public final String getArticles(Model model) {
//        Collection<Article> articles = articleService.getAllArticles();
        Collection<ArticleDto> articleDtos = articleService.getAllArticleDto();
//        model.addAttribute("articles",articles);
        model.addAttribute("articleDtos", articleDtos);
        return   "articles";
    }

    //add article
    @GetMapping (value ="/article")
    public final String getAddArticle(Model model){
        Collection <Author> authors = authorService.getAllAuthor();
        model.addAttribute("authors",authors);
        model.addAttribute("article",new Article());
        return "article";
    }

    //add article POST
    @PostMapping(value ="/article")
    public final String postAddArticle(Model model, Article article){
        articleService.addArticle(article);
        return "redirect:/articles";
    }

    @GetMapping (value = "/article/{id}")
    public final String getArticleById(@PathVariable Integer id, Model model){
        Collection <Author> authors = authorService.getAllAuthor();
        model.addAttribute("authors",authors);
        Article article = articleService.getArticleById(id);
        model.addAttribute("article",article);
        return "article";
    }

    @PostMapping (value = "/article/{id}")
    public final String postEditArticle (Model model, Article article){
        articleService.updateArticle(article);
        return "redirect:/articles";
    }

    @GetMapping(value = "/article/{id}/delete")
    public final String deleteCall(@PathVariable final int id) {
        articleService.deleteArticleById(id);
        return "redirect:/articles";
    }


}
