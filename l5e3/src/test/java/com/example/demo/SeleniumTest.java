package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        //start driver, open chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");

        //fill in the fields
        WebElement inputField = driver.findElement(By.name("animalText"));
        inputField.sendKeys("Manatee");

        inputField = driver.findElement(By.name("adjective"));
        inputField.sendKeys("Whirling");

        //submit it 5 times
        for (int i = 0; i < 5; i++) {
            inputField.submit();

            List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));
            System.out.println("trainingResults.size() = " + trainingResults.size());
        }

        // then get the element by the class conclusionMessage and print it
        WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
        System.out.println("conclusionResult.getText() = " + conclusionResult.getText());

        Thread.sleep(5000);
        driver.quit();
    }
};