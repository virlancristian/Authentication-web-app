package com.example.backendandapi.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageRouterController {
    @GetMapping(value= {"/", "/create_account", "/login", "/account", "change_password"})
    public String router() {
        return "../static/index";
    }
}
