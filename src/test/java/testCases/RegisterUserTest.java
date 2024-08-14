package testCases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.TestAllureReportListener;

import static utils.CommonUtils.generateEmailId;
import static utils.CommonUtils.getRandomNumber;
import static utils.DriverFactory.getDriver;
@Listeners({TestAllureReportListener.class})
public class RegisterUserTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    @Epic("User registration")
    @Feature("New user registration")
    @Story("Successful user registration")
    @Test(groups = {"Regression", "SmokeTest"})
    @Description("Verify user registration")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewUserFormValidation(){
        homePage = new HomePage(getDriver());
        loginPage = homePage.navigateToLogInPage();
        getSoftAssert().assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        registrationPage = loginPage.navigateToSignUpPage();
        getSoftAssert().assertEquals(registrationPage.getRegistrationPageTitle(), "Register - Practice Software Testing - Toolshop - v5.0");
        registrationPage.enterFirstName(testDataMap.get("first_name"));
        registrationPage.enterLastName(testDataMap.get("last_name"));
        registrationPage.enterDateOfBirth(testDataMap.get("month"),
                testDataMap.get("day"), testDataMap.get("year"));
        registrationPage.enterAddress(testDataMap.get("address"));
        registrationPage.enterPostCode(testDataMap.get("postcode"));
        registrationPage.enterCity(testDataMap.get("city"));
        registrationPage.enterState(testDataMap.get("state"));
        registrationPage.selectCountry(testDataMap.get("country"));
        registrationPage.enterPhone(getRandomNumber(10));
        String email = generateEmailId();
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(testDataMap.get("password"));
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.getErrorCount(), 0, "Error is displayed");
    }
}
