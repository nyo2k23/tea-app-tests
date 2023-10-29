package com.thateatests.tests;

import com.thateatests.pages.HomePage;
import com.thateatests.pages.LoginPage;
import com.thateatests.tests.users.model.userTestData;
import com.thateatests.util.Constants;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private userTestData failLoginTestDataPath;
    //private DriverManager driverManager = new DriverManager("safari");

    @BeforeTest
    public void setHomePage() {
        //this.driver = driverManager.getBrowserDriver();
//        WebDriverManager.chromedriver().setup();
//        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void goBackToLoginPage() {
        homePage.goTo();
    }

//    @BeforeTest
//    public  void setUpTestDataPaths(){
//        this.failLoginTestDataPath = JsonUtil.getTestData
//                ("src/test/resources/test-data/fail.json", userTestData.class);
//    }


    @Test()
    public void ATestLoginElements() {
        loginPage.goTo();
        Assert.assertEquals(loginPage.getUsernameFromProfile(), Constants.LOGIN_OR_REGISTER_PROMPT);
        Assert.assertEquals(loginPage.loginFormIsDisplayed(), true);
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }


    @Test()
    public void BUsernameLengthLoginFail() {
        loginPage.goTo();
        loginPage.enterUserDetails("u", "hjgjsk7sks8");
        Assert.assertEquals
                (loginPage.getUsernameLengthErrorMessage(), Constants.USERNAME_LENGTH_ERROR_MSG);
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);

    }

    @Test()
    public void CPasswordLengthLoginFail() {
        //loginPage.clearUserLoginDetailsFromForm();
        //String s = Keys.chord(Keys.CONTROL,"a", Keys.DELETE);
        //loginPage.enterUserDetails(s, s);
        loginPage.goTo();
        loginPage.enterUserDetails("jh", "uu82dsss");
        Assert.assertEquals
                (loginPage.getPasswordLengthErrorMessage(), Constants.PASSWORD_LENGTH_ERROR_MSG);
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }

    @Test()
    public void DTestLoginSuccess() {
        //TODO
        // use user after successful registration test or register here
        loginPage.goTo();
        loginPage.enterUserDetails("ghos", "password!");
        loginPage.submitLogin();
        Assert.assertEquals(loginPage.logoutButtonIsDisplayed(), true);
        Assert.assertEquals(loginPage.getUsernameFromProfile(), "ghos");
    }

    @Test(dependsOnMethods = "DTestLoginSuccess")
    public void ETestLogoutSuccess() {
        loginPage.logOut();
        Assert.assertEquals(loginPage.getUsernameFromProfile(), Constants.LOGIN_OR_REGISTER_PROMPT);
        Assert.assertEquals(homePage.logInAndRegisterButtonsAreVisible(), true);
    }
}
