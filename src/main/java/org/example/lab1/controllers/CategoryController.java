package org.example.lab1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/test")
    public String testEndpoint() {
        return "Test Successful";
    }
}

