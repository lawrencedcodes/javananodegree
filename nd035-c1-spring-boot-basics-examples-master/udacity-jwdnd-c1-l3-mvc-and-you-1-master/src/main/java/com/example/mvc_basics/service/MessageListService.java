package com.example.mvc_basics.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.model.ChatMessage;

import org.springframework.stereotype.Service;

@Service
public class MessageListService {

    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageListService bean");
        this.chatMessages = new ArrayList<>();
    }

    public void addChatMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}
