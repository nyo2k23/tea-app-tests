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

public class FailedLoginTests extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private UserTestData userTestData;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        homePage.goTo(Config.get(Constants.UI_URL));
    }

    @BeforeMethod
    public void goBackToLoginPage() {
        loginPage.goToLandingPage();
        loginPage.goTo();
    }

    @Test()
    public void TestLoginElements() {
        Assert.assertEquals(loginPage.getUsernameFromProfile(), Constants.LOGIN_OR_REGISTER_PROMPT);
        Assert.assertEquals(loginPage.loginFormIsDisplayed(), true);
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }


    @Test()
    @Parameters("usernameLengthFailTestDataPath")
    public void UsernameLengthLoginFail(String usernameLengthFailTestDataPath) {
        this.userTestData = JsonUtil.getTestData(usernameLengthFailTestDataPath, UserTestData.class);
//        loginPage.goTo();
        loginPage.enterUserDetails(userTestData.username(), userTestData.password());
        Assert.assertEquals
                (loginPage.getUsernameLengthErrorMessage(), Constants.USERNAME_LENGTH_ERROR_MSG);
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);

    }

    @Test()
    @Parameters("pwdLengthFailTestDataPath")
    public void PasswordLengthLoginFail(String pwdLengthFailTestDataPath) {
        this.userTestData = JsonUtil.getTestData(pwdLengthFailTestDataPath, UserTestData.class);
        loginPage.enterUserDetails(userTestData.username(), userTestData.password());
        Assert.assertEquals
                (loginPage.getPasswordLengthErrorMessage(), Constants.PASSWORD_LENGTH_ERROR_MSG);
        Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }

    @Test()
    @Parameters("loginFailTestDataPath")
    public void unregisteredLoginFail(String loginFailTestDataPath) {
        this.userTestData = JsonUtil.getTestData(loginFailTestDataPath, UserTestData.class);
        loginPage.enterUserDetails(userTestData.username(), userTestData.password());
        Assert.assertEquals
                (loginPage.getLoginFailMsg(), Constants.LOGIN_FAIL_MSG);
        //Assert.assertEquals(loginPage.submitButtonIsEnabled(), false);
    }
}
