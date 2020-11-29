package com.example.mvc_basics.controller;

import java.time.Instant;

import com.example.mvc_basics.MessageListService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("welcomeMessage", Instant.now().toString());
        model.addAttribute("messages", this.messageListService.getMessages());
        return "home";
    }

}