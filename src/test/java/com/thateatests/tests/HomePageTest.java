package com.thateatests.tests;

import com.thateatests.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.driver = new FirefoxDriver();
        this.homePage = new HomePage(driver);
    }

    @Test
    public void testHomePage() {
        homePage.goTo();
        Assert.assertEquals("Please Login or register", homePage.getUserPrompt());
    }
}
