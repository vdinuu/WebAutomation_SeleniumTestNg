package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumActions.isElementDisplayed;

/**
 * Represents the MyAccount Page of the application.
 * This class contains all the web elements and methods specific to the MyAccount page.
 * It follows the Page Object Model design pattern to maintain a clean separation
 * between test code and page specific code.
 *
 * */
public class MyAccountPage {
    WebDriver driver;
    public MyAccountPage(WebDriver driver){
        this.driver = driver;
    }
    private final By header_MyAccount = By.xpath("//h1[text()='My account']");
    @Step("Verify if my account page is displayed after login")
    public boolean isMyAccountPageDisplayed(){
        return isElementDisplayed(header_MyAccount);
    }
}
