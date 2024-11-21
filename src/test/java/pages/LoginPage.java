package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumActions.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By textBox_EmailId = By.id("email");
    private By textBox_Password = By.xpath("//input[@id='password']");
    private By btn_Login = By.xpath("//input[@class='btnSubmit']");
    private By link_Register = By.xpath("//a[contains(@href, 'register')]");
    private By header_Login = By.xpath("//h3[contains(text(), \"Login\")]");

    @Step("Navigate to Sign Up page")
    public RegistrationPage navigateToSignUpPage(){
        clickElement(link_Register);
        return new RegistrationPage(driver);
    }
    @Step("Get Login page title")
    public String getLoginPageTitle(){
        waitUntilDisplayed(header_Login);
        return getPageTitle();
    }

    @Step("Enter user name")
    public void enterUserName(String userName){
        enterText(textBox_EmailId, userName);
    }
    @Step("Enter password")
    public void enterPassword(String password){
        clickElement(textBox_Password);
        enterText(textBox_Password, password);
    }
    @Step("Click on Login button")
    public void clickLoginButton(){
        clickElement(btn_Login);
    }
    @Step("Login to application by entering valid credentials")
    public MyAccountPage loginToApplication(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
        return new MyAccountPage(driver);
    }


}
