package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.Listener;

import static utils.DriverFactory.getDriver;
@Listeners(Listener.class)
public class RegisterUserTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    @Test
    @Description("Verify user registration")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewUserFormValidation(){
        homePage = new HomePage(getDriver());
        loginPage = homePage.navigateToLogInPage();
        Assert.assertEquals(loginPage.getLoginPageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        registrationPage = loginPage.navigateToSignUpPage();
        Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register - Practice Software Testing - Toolshop - v5.0");
        registrationPage.fillRegistrationForm(TestBase.testDataMap.get("first_name"),
                TestBase.testDataMap.get("last_name"),
                TestBase.testDataMap.get("dob"), TestBase.testDataMap.get("address"),
                TestBase.testDataMap.get("postcode"),
                TestBase.testDataMap.get("city"), TestBase.testDataMap.get("state"),
                TestBase.testDataMap.get("country"),
                TestBase.testDataMap.get("email"), TestBase.testDataMap.get("password"));
    }
}
