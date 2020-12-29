package com.example.demo;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
                //start the driver, open chrome to our target url
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.get("http://localhost:8080/animal");
        
                //find the fields we want by id and fill them in
                WebElement inputField = driver.findElement(By.id("animalText"));
                inputField.sendKeys("Manatee");
        
                inputField = driver.findElement(By.id("adjective"));
                inputField.sendKeys("Whirling");
        
                List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));
        
                // The field-values don’t clear on submit 
                for(int i = 0; i < 5; i++) {
                    
                    inputField = driver.findElement(By.id("adjective"));
                    inputField.submit();
        
                    System.out.println("trainingResults.size() = " + trainingResults.size());
                }
        
                // then get the element by the class conclusionMessage and print it
                WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
                System.out.println("conclusionResult.getText() = " + conclusionResult.getText());
        
                Thread.sleep(5000);
                driver.quit();
            }
        }
}
