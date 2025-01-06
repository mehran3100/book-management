package com.mehran.KTBooks.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Return your home page (e.g., index.html)
    }

}
