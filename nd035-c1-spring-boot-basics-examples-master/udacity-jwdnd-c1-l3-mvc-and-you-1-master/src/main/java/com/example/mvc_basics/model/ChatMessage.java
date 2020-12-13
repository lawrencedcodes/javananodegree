package com.example.mvc_basics.model;

public class ChatMessage {
    private String username;
    private String messagetext;
    private Integer messageid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messagetext;
    }

    public void setMessageText(String messagetext) {
        this.messagetext = messagetext;
    }

    public Integer getMessageId() {
        return messageid;
    }

    public void setMessageId(Integer messageid) {
        this.messageid = messageid;
    }
}
