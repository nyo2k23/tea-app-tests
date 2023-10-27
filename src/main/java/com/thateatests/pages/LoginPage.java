package com.thateatests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(css = "form div:nth-child(1) #outlined-basic-helper-text")
    private WebElement usernameLengthErrorMsg;

    @FindBy(css = "form div:nth-child(2) #outlined-basic-helper-text")
    private WebElement passwordLengthErrorMsg;


    @FindBy(css = "#profile div.text-m.text-center")
    private WebElement profileUsername;

    @FindBy(css = "#profile button")
    private WebElement logoutButton;


    /*
    @FindBy(css = "form[name='login']")
    private WebElement x;
*/
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }


    public void submitUserDetails(String username, String password){
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }

    public String getButtonName(){
        return loginButton.getText();
    }

    public String getUsernameLengthErrorMessage(){
        return usernameLengthErrorMsg.getText();
    }

    public String getPasswordLengthErrorMessage(){
        return passwordLengthErrorMsg.getText();
    }

    public boolean submitButtonIsEnabled(){
        return this.loginButton.isEnabled();
    }

    public boolean logoutButtonIsVisible(){
        return this.logoutButton.isEnabled();
    }

    public String getUsernameFromProfile(){
        return this.profileUsername.getText();
    }

    public void logOut(){
        this.logoutButton.click();
    }
}
