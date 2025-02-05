package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumActions.clickElement;

/**
 * Represents the Home Page of the application.
 * This class contains all the web elements and methods specific to the Home page.
 * It follows the Page Object Model design pattern to maintain a clean separation
 * between test code and page specific code.
 *
 * */
public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private final By link_SignIn = By.xpath("//a[contains(@href, 'login')]");
    @Step("Navigate to Login In Page")
    public LoginPage navigateToLogInPage(){
        clickElement(link_SignIn);
        return new LoginPage(this.driver);
    }
}
