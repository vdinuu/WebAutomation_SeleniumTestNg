package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumActions.isElementDisplayed;

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
