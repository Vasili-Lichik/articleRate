package com.brest.test.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home controller.
 */
@Controller
public class HomeController {

    /**
     * Redirect to articles.
     *
     * @return template name
     */
    @GetMapping(value = "/*")
    public final String defaultPageRedirect() {
        return "redirect:/articles";
    }

}