package testCases;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

//    @Test(dependsOnMethods = {"testCases.RegisterUserTest.registerNewUserFormValidation"})
    @Test()
    @Description("Verify user registration")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        homePage = new HomePage(getDriver());
        loginPage = homePage.navigateToLogInPage();
        getSoftAssert().assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
//        String path = SeleniumActions.captureScreenshot(getDriver(), "LoginPage");
//        try {
//            Allure.addAttachment("LoginPage", new FileInputStream(path));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        myAccountPage = loginPage.loginToApplication(testDataMap.get("username"),
                testDataMap.get("password"));
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(), "Login unsuccessful");

    }
}
