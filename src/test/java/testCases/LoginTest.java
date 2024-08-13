package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.TestAllureReportListener;

import static utils.DriverFactory.getDriver;

@Listeners(TestAllureReportListener.class)
public class LoginTest extends TestBase {
    @Feature("User login")
    @Test(dependsOnMethods = {"testCases.RegisterUserTest.registerNewUserFormValidation"})
    @Description("Verify user login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = homePage.navigateToLogInPage();
        getSoftAssert().assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        MyAccountPage myAccountPage = loginPage.loginToApplication(testDataMap.get("username"),
                testDataMap.get("password"));
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(), "Login unsuccessful");
    }
    @Feature("User login")
    @Test
    @Description("Verify user login")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidLoginTest() {
        HomePage hmePage = new HomePage(getDriver());
        LoginPage logInPage = hmePage.navigateToLogInPage();
        getSoftAssert().assertEquals(logInPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        MyAccountPage myAccPage = logInPage.loginToApplication(testDataMap.get("username"),
                testDataMap.get("password"));
        Assert.assertFalse(myAccPage.isMyAccountPageDisplayed(), "Login successful with invalid credentials");
    }
}
