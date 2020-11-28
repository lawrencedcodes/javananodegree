package com.example.mvc_basics.controller;

import java.time.Instant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("welcomeMessage", Instant.now().toString());
        model.addAttribute("messages",
                new String[] { "First Greeting", "Second Greeting", "Third Greeting", "Fourth Greeting" });
        return "home";
    }

}