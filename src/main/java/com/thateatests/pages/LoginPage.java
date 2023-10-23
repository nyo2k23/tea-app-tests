package com.thateatests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement loginButton;

    /*
    @FindBy(css = "form[name='login']")
    private WebElement x;
*/
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void enterUserDetails(String username, String password){
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
    }

    public String getButtonName(){
        return loginButton.getText();
    }
}
