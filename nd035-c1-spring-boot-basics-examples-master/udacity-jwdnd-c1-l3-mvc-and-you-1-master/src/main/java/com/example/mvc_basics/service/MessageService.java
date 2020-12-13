package com.example.mvc_basics.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.model.ChatMessage;

import org.springframework.stereotype.Service;

import com.example.mvc_basics.mapper.MessagesMapper;

@Service
public class MessageService {
    private MessagesMapper messagesMapper;

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
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messagesMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messagesMapper.getAllMessages();
    }
}
