package com.thateatests.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css="#top-bar div:nth-child(1) a")
    private WebElement banner;

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement loginButton;

    @FindBy(tagName = "form")
    private WebElement loginForm;

    @FindBy(css = "form div:nth-child(1) #outlined-basic-helper-text")
    private WebElement usernameLengthErrorMsg;

    @FindBy(css = "form div:nth-child(2) #outlined-basic-helper-text")
    private WebElement passwordLengthErrorMsg;


    @FindBy(css = "#profile div.text-m.text-center")
    private WebElement profileUsername;

    @FindBy(css = "#profile button")
    private WebElement logoutButton;

    @FindBy(css = "button#loginbtn")
    private WebElement loginPagePortal;

    @FindBy(className = "MuiBox-root")
    private WebElement progressCircle;

    @FindBy(css = "div.bg-yellow-50.px-4.py-3.text-red-400.m-2")
    private WebElement loginFailMsg;

    /*
    @FindBy(css = "form[name='login']")
    private WebElement x;
*/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goToLandingPage(){
        this.banner.click();
    }

    public void x(Keys k) {
        this.usernameInput.sendKeys(k);
        this.passwordInput.sendKeys(k);
    }

    private void clearInputs(List<WebElement> forms) {
        //forms.forEach(this::clearText);
        //forms.forEach(WebElement::clear);
        forms.forEach((form) -> form.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
    }


    public void clearText(WebElement element) {
        String areaText = element.getText();
        int lengthOfString = areaText.length();

        for (int i = 0; i < lengthOfString; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clearUserLoginDetailsFromForm() {
        this.clearInputs(Arrays.asList(this.usernameInput, this.passwordInput));
    }

    public void submitLogin() {
        this.loginButton.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutButton));
        //this.wait.until(d -> serverHasResponded());
    }


    public void enterUserDetails(String username, String password) {

        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
    }

    public boolean serverHasResponded() {
        return this.loginFailMsg.isDisplayed() || this.logoutButton.isDisplayed();
    }

    public void goTo() {
        this.loginPagePortal.click();
    }

    public String getButtonName() {
        return loginButton.getText();
    }

    public String getUsernameLengthErrorMessage() {
        return usernameLengthErrorMsg.getText();
    }

    public String getPasswordLengthErrorMessage() {
        return passwordLengthErrorMsg.getText();
    }

    public String getLoginFailMsg() {
        return loginFailMsg.getText();
    }

    public boolean submitButtonIsEnabled() {
        return this.loginButton.isEnabled();
    }

    public boolean logoutButtonIsDisplayed() {
        return this.logoutButton.isDisplayed();
    }

    public String getUsernameFromProfile() {
        return this.profileUsername.getText();
    }

    public boolean loginFormIsDisplayed() {
        return this.loginForm.isDisplayed();
    }

    public void logOut() {
        this.logoutButton.click();
    }
}
