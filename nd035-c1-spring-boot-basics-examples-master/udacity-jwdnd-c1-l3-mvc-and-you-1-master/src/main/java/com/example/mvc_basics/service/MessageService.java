package com.example.mvc_basics.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.model.ChatMessage;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.chatMessages.add(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}
