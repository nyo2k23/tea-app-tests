package com.thateatests.tests;

import com.thateatests.pages.HomePage;
import com.thateatests.util.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;
    //private DriverManager driverManager = new DriverManager("chrome");
    //private WebDriver driver;

    @BeforeTest
    public void setHomePage() {
        //WebDriverManager.chromedriver().setup();
        //this.driver = new ChromeDriver();
        //this.driver = driverManager.getBrowserDriver();
        this.homePage = new HomePage(driver);
    }

    @Test
    public void testHomePage() {
        homePage.goTo();
        Assert.assertEquals(Constants.LOGIN_OR_REGISTER_PROMPT, homePage.getUserPrompt());
        Assert.assertEquals(homePage.logInAndRegisterButtonsAreVisible(), true);
    }
//    @AfterTest
//    public void quitDriver(){
//        this.driver.quit();
//    }
}
