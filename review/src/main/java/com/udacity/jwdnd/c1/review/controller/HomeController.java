package com.udacity.jwdnd.c1.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model  ) {
        model.addAttribute("welcomeMessage", Instant.now().toString());
        return "home";
    }
    @RequestMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("getusers", "The users are Lawrence, Joy, Maalik, Taylor, and Nina");
        return "home";
    }
}
