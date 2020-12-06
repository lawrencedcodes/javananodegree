package com.example.mvc_basics;

public class ChatMessage {

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMnessageText() {
        return this.mnessageText;
    }

    public void setMnessageText(String mnessageText) {
        this.mnessageText = mnessageText;
    }

    public String username;
    public String mnessageText;
}

// <div th:each="chatmessage: ${chatMessages}">
// <p th:text="${chatMessage.username}">Error Text in paragraph tag 1</p>
// <p th:text="${chatMessage.messageText}">Error Text in paragraph tag 2</p>
// </div>