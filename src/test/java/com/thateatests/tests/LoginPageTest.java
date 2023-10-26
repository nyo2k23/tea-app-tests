package com.thateatests.tests;

import com.thateatests.pages.HomePage;
import com.thateatests.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private DriverManager driverManager = new DriverManager("safari");

    @BeforeTest
    public void setHomePage(){
        this.driver = driverManager.getBrowserDriver();
        this.homePage = new HomePage(driver);
        homePage.goTo();

    }

    @Test
    public void testLoginSuccess(){

    }

    @Test
    public void login(){

    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
