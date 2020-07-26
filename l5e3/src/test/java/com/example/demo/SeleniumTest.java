package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");
        WebElement inputField1 = driver.findElement(By.name("animalText"));
        inputField1.sendKeys("cat");
        inputField1.submit();
        WebElement inputField2 = driver.findElement(By.name("adjective"));
        inputField2.sendKeys("fluffy");
        inputField2.submit();
        List<WebElement> results = driver.findElements(By.cssSelector("conclusionMessage"));
        for (WebElement element : results) {
            String link = element.getAttribute("href");
            System.out.println(link);
        }
        Thread.sleep(5000);
        driver.quit();
    }
}




