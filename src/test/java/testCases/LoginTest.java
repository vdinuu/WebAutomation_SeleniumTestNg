package testCases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.SeleniumActions;
import utils.TestAllureReportListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utils.DriverFactory.getDriver;

@Listeners(TestAllureReportListener.class)
public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    @Feature("User login")
    @Test(dependsOnMethods = {"testCases.RegisterUserTest.registerNewUserFormValidation"})
    @Description("Verify user login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        homePage = new HomePage(getDriver());
        loginPage = homePage.navigateToLogInPage();
        getSoftAssert().assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        myAccountPage = loginPage.loginToApplication(testDataMap.get("username"),
                testDataMap.get("password"));
        Assert.assertTrue(!myAccountPage.isMyAccountPageDisplayed(), "Login unsuccessful");
    }

    @Test
    @Description("Verify user login")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidLoginTest() {
        homePage = new HomePage(getDriver());
        loginPage = homePage.navigateToLogInPage();
        getSoftAssert().assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        myAccountPage = loginPage.loginToApplication(testDataMap.get("username"),
                testDataMap.get("password"));
        Assert.assertFalse(myAccountPage.isMyAccountPageDisplayed(), "Login successful with invalid credentials");
    }
}
