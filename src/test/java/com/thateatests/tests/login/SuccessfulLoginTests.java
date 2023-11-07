package com.thateatests.tests.login;

import com.thateatests.pages.HomePage;
import com.thateatests.pages.LoginPage;
import com.thateatests.tests.BaseTest;
import com.thateatests.tests.users.model.UserTestData;
import com.thateatests.util.Config;
import com.thateatests.util.Constants;
import com.thateatests.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SuccessfulLoginTests extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private UserTestData userTestData;

    @BeforeTest
    @Parameters("loginSuccessTestDataPath")
    public void setHomePage(String loginSuccessTestDataPath) {
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.userTestData = JsonUtil.getTestData(loginSuccessTestDataPath, UserTestData.class);
        homePage.goTo(Config.get(Constants.UI_URL));
    }


    @Test()
    public void TestLoginElements() {
        loginPage.goTo();
        Assert.assertEquals(loginPage.getUsernameFromProfile(), Constants.LOGIN_OR_REGISTER_PROMPT);
        Assert.assertEquals(loginPage.loginFormIsDisplayed(), true);
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }


    @Test(dependsOnMethods = "TestLoginElements")
    public void TestLoginSuccess() {
        loginPage.enterUserDetails(userTestData.username(), userTestData.password());
        loginPage.submitLogin();
        Assert.assertEquals(loginPage.logoutButtonIsDisplayed(), true);
        Assert.assertEquals(loginPage.getUsernameFromProfile(), userTestData.username());
    }

    @Test(dependsOnMethods = "TestLoginSuccess")
    public void TestLogoutSuccess() {
        loginPage.logOut();
        Assert.assertEquals(loginPage.getUsernameFromProfile(), Constants.LOGIN_OR_REGISTER_PROMPT);
        Assert.assertEquals(homePage.logInAndRegisterButtonsAreVisible(), true);
    }
}
