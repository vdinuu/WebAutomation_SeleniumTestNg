package testCases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_action_handler.Register;
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
    public void registerNewUserFormValidation() {
        homePage = new HomePage(getDriver());
        loginPage = homePage.navigateToLogInPage();
        getSoftAssert().assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        registrationPage = loginPage.navigateToSignUpPage();
        getSoftAssert().assertEquals(registrationPage.getRegistrationPageTitle(), "Register - Practice Software Testing - Toolshop - v5.0");
        String email = generateEmailId();
        Register register = new Register.RegisterBuilder()
                .setFirstName(testDataMap.get("first_name"))
                .setLastName(testDataMap.get("last_name"))
                .setMonth(testDataMap.get("month"))
                .setDay(testDataMap.get("day"))
                .setYear(testDataMap.get("year"))
                .setAddress(testDataMap.get("address"))
                .setPostcode(testDataMap.get("postcode"))
                .setCity(testDataMap.get("city"))
                .setState(testDataMap.get("state"))
                .setCountry(testDataMap.get("country"))
                .setPhoneNumber(getRandomNumber(10))
                .setEmail(email)
                .setPassword(testDataMap.get("password"))
                .build();
        registrationPage.fillRegistrationForm(register);
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.getErrorCount(), 0, "Error is displayed");
    }
}
