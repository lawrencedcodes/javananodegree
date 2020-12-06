package com.example.mvc_basics.controller;

import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.service.MessageListService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageListService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model) {
        this.messageListService.addChatMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageListService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("choices")
    public String[] choices() {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
