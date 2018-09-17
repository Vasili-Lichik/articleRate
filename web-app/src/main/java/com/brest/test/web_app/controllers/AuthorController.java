package com.brest.test.web_app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    @GetMapping (value = "/authors")
    public String getAuthors (Model model){
        return "authors";
    }
}
