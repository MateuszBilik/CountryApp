package com.asap.country_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigatePageController {

    @GetMapping("/")
    public String page() {
        return "main_page";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }
}
