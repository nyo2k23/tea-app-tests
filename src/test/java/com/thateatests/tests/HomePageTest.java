package com.thateatests.tests;

import com.thateatests.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private DriverManager driverManager = new DriverManager("safari");

    @BeforeTest
    public void setHomePage(){
        //this.driver = new ChromeDriver();
        this.driver = driverManager.getBrowserDriver();
        this.homePage = new HomePage(driver);
    }

    @Test
    public void testHomePage() {
        this.homePage.goTo();
        Assert.assertEquals("Please Login or register", homePage.getUserPrompt());
        Assert.assertEquals(1,1);  //testing the tests
    }

    @AfterTest
    public void closeStuff(){
        this.driver.close();
    }

}
