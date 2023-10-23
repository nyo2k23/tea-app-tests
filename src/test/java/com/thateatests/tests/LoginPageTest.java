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

    @BeforeTest
    public void setHomePage(){
        this.driver = new FirefoxDriver();
        this.homePage = new HomePage(driver);
    }

    @Test
    public void choosePath(){
        homePage.goTo();
        homePage.login();
        Assert.assertEquals("login", loginPage.getButtonName());
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
