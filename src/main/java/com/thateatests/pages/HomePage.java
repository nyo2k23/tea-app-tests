package com.thateatests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class HomePage {
    private final WebDriver driver;
    private WebDriverWait wait;
    private String homePageURL;

    private HashMap<String, String> responses;


    @FindBy(css = "button#loginbtn")
    private WebElement loginBtn;

    @FindBy(css = "button#registerbtn")
    private WebElement registerBtn;

    @FindBy(css = "#profile div:last-child")
    private WebElement userPrompt;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        this.homePageURL = System.getenv("UI_URL");
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        System.out.println(System.getenv("UI_URL"));
        this.driver.get(homePageURL);
        wait.until(d -> loginBtn.isDisplayed()&& registerBtn.isDisplayed());
    }

    public static void main(String[] args) {
        System.out.println("URL null?: " + System.getenv("URL_URL")!=null);
    }
    public void register(){
        this.registerBtn.click();
    }

    public void login(){
        this.loginBtn.click();
    }

    public String getUserPrompt() {
        return userPrompt.getText();
    }
    public HashMap<String, String> getResponses() {
        return responses;
    }

    public void setResponses(String k, String v) {
        this.responses.put(k,v);
    }
}
