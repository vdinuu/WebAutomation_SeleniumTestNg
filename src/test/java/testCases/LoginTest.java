package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.Listener;

import static utils.DriverFactory.getDriver;

@Listeners(Listener.class)
public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Test(dependsOnMethods = {"testCases.RegisterUserTest.registerNewUserFormValidation"})
    @Description("Verify user registration")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        homePage = new HomePage(getDriver());
        loginPage = homePage.navigateToLogInPage();
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        myAccountPage = loginPage.loginToApplication(testDataMap.get("username"),
                testDataMap.get("password"));
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(), "Login unsuccessful");

    }
}
