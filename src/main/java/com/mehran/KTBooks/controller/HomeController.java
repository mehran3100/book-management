package com.mehran.KTBooks.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Return your home page (e.g., index.html)
    }

}
