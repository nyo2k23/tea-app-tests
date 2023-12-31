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

    private HashMap<String, String> responses;

    @FindBy(css = "#top-bar a[href='/']")
    private WebElement linkToHomepage;

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
        PageFactory.initElements(driver, this);
    }

    public void goTo(String homePageURL) {
        System.out.println("going to url: " + homePageURL);
        this.driver.get(homePageURL);
        wait.until(d -> loginBtn.isDisplayed() && registerBtn.isDisplayed());
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


    public boolean logInAndRegisterButtonsAreVisible(){
        return this.loginBtn.isDisplayed() && this.registerBtn.isDisplayed();
    }
}