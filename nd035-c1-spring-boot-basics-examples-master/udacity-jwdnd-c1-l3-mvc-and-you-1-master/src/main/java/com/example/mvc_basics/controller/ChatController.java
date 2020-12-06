package com.example.mvc_basics.controller;

import com.example.mvc_basics.MessageListService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/chat")

    @PostMapping("/chat")
}
