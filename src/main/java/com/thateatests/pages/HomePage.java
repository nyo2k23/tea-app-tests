package com.thateatests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HomePage {
    private final WebDriver driver;
    private WebDriverWait wait;

    private HashMap<String, String> responses;


    @FindBy(id = "loginbtn")
    private WebElement loginBtn;

    @FindBy(id = "registerbtn")
    private WebElement registerBtn;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.responses = new HashMap<>();
    }

    public void goTo() {
        this.driver.get(System.getenv("URL"));
    }

    public void register(){
        this.registerBtn.click();
    }

    public void login(){
        this.loginBtn.click();
    }


    public HashMap<String, String> getResponses() {
        return responses;
    }

    public void setResponses(String k, String v) {
        this.responses.put(k,v);
    }
}
