package com.example.mvc_basics;

import com.example.mvc_basics.model.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "messageType")
    private WebElement messageType;

    @FindBy(id = "submitMessage")
    private WebElement submittMessage;

    @FindBy(id = "")
    private WebElement blahblahblah;

}
