package com.brest.test.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Article controller.
 */
@Controller
public class ArticleController {


    @GetMapping (value = "/articles")
    public final String getArticles(Model model) {

        return "articles";
    }



    }
