package testCases;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_action_handler.Register;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.DataMap;
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
                .setFirstName((String) DataMap.getDataMap().get("first_name"))
                .setLastName((String) DataMap.getDataMap().get("last_name"))
                .setMonth((String) DataMap.getDataMap().get("month"))
                .setDay((String) DataMap.getDataMap().get("day"))
                .setYear((String) DataMap.getDataMap().get("year"))
                .setAddress((String) DataMap.getDataMap().get("address"))
                .setPostcode((String) DataMap.getDataMap().get("postcode"))
                .setCity((String) DataMap.getDataMap().get("city"))
                .setState((String) DataMap.getDataMap().get("state"))
                .setCountry((String) DataMap.getDataMap().get("country"))
                .setPhoneNumber(getRandomNumber(10))
                .setEmail(email)
                .setPassword((String) DataMap.getDataMap().get("password"))
                .build();
        registrationPage.fillRegistrationForm(register);
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.getErrorCount(), 0, "Error is displayed");
    }
}
