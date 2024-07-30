package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumActions.clickElement;
import static utils.SeleniumActions.getPageTitle;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By textBox_EmailId = By.id("email");
    private By textBox_Password = By.id("password");
    private By btn_Login = By.xpath("//input[@class='btnSubmit']");
    private By link_Register = By.xpath("//a[contains(@href, 'register')]");

    @Step("Navigate to Sign Up page")
    public RegistrationPage navigateToSignUpPage(){
        clickElement(link_Register);
        return new RegistrationPage(driver);
    }
    @Step("Get Login page title")
    public String getLoginPageTitle(){
        return getPageTitle();
    }


}
