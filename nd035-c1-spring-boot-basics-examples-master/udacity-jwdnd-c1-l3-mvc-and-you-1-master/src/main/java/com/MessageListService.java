package com.example.mvc_basics;

import java.util.ArrayList;
import java.util.List;

public class MessageListService {

    private List<String> messages;

    public MessageListService() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }

}
