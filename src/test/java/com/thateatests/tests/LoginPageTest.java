package com.thateatests.tests;

import com.thateatests.pages.HomePage;
import com.thateatests.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    //private DriverManager driverManager = new DriverManager("safari");

    @BeforeTest
    public void setHomePage(){
        //this.driver = driverManager.getBrowserDriver();
//        WebDriverManager.chromedriver().setup();
//        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        homePage.goTo();
    }

    @Test
    public void testLoginElements(){

    }
    @Test
    public void testLoginSuccess(){
        //TODO
        // use user after successful registration test or register here
        //loginPage.submitUserDetails("", "");
        //Assert.assertEquals(loginPage.logoutButtonIsVisible(), true);
        //Assert.assertEquals(loginPage.getUsernameFromProfile(), usernamefromtestshere);

    }

    @Test(dependsOnMethods = "testLoginSuccess")
    public void testLogoutSuccess(){
        loginPage.logOut();
        Assert.assertEquals(loginPage.getUsernameFromProfile(), "Please Login or register");
        Assert.assertEquals(homePage.logInAndRegisterButtonsAreVisible(),true);
    }
    @Test
    public void usernameLengthLoginFail(){
        loginPage.submitUserDetails("l","o90aJ9aKL");
        Assert.assertEquals
                (loginPage.getUsernameLengthErrorMessage(), "Should be at least 2 characters long");
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }

    @Test
    public void passwordLengthLoginFail(){
        loginPage.submitUserDetails("jh","uu82dsss");
        Assert.assertEquals
                (loginPage.getPasswordLengthErrorMessage(), "Password should be at least 9 characters long");
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }

}
