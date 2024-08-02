package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

import static utils.SeleniumActions.*;

public class RegistrationPage {
    private By textBox_FirstName = By.id("first_name");
    private By textBox_LastName = By.id("last_name");
    private By textBox_DateOfBirth = By.id("dob");
    private By textBox_Address = By.id("address");
    private By textBox_PostCode = By.id("postcode");
    private By textBox_City = By.id("city");
    private By textBox_State = By.id("state");
    private By drpDown_Country = By.id("country");
    private By textBox_phone = By.id("phone");
    private By textBox_Email = By.id("email");
    private By textBox_Password = By.id("password");
    private By btn_Register = By.cssSelector("button.btnSubmit");
    private By mandatory_alert = By.cssSelector("div.alert-danger");
    WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Get Registration page title")
    public String getRegistrationPageTitle(){
        return getPageTitle();
    }
    @Step("Enter first name")
    public void enterFirstName(String first_Name){
        enterText(textBox_FirstName, first_Name);
    }
    @Step("Enter last name")
    public void enterLastName(String last_Name){
        enterText(textBox_LastName, last_Name);
    }
    @Step("Enter Date of Birth")
    public void enterDateOfBirth(String dob){
        setAttribute(textBox_DateOfBirth, "value", dob);
    }
    @Step("Enter address")
    public void enterAddress(String address){
        enterText(textBox_Address, address);
    }
    @Step("Enter postcode")
    public void enterPostCode(String postcode){
        enterText(textBox_PostCode, postcode);
    }
    @Step("Enter city")
    public void enterCity(String city){
        enterText(textBox_City, city);
    }
    @Step("Enter state")
    public void enterState(String state){
        enterText(textBox_State, state);
    }
    @Step("Select country")
    public void selectCountry(String country){
        selectDropDown(drpDown_Country, country);
    }
    @Step("Enter phone number")
    public void enterPhone(String number){
        enterText(textBox_phone, number);
    }
    @Step("Enter email id")
    public void enterEmail(String emailId){
        enterText(textBox_Email, emailId);
    }
    @Step("Enter password")
    public void enterPassword(String password){
        enterText(textBox_Password, password);
    }
    @Step("Click Register button")
    public void clickRegisterButton(){
        clickElement(btn_Register);
    }
    @Step("Fill details in registration form")
    public void fillRegistrationForm(String firstName, String lastName, String dob, String address,
                                     String postcode, String city, String state, String country,
                                     String emailId, String password){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterDateOfBirth(dob);
        enterAddress(address);
        enterPostCode(postcode);
        enterCity(city);
        enterState(state);
        selectCountry(country);
        enterPhone(CommonUtils.getRandomNumber(10));
        enterEmail(emailId);
        enterPassword(password);
        clickRegisterButton();
    }
    public int getErrorCount(){
        waitUntilNumberElementsMoreThanSize(mandatory_alert, 0);
        return getSizeOfElements(mandatory_alert);
    }
}
