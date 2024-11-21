package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_action_handler.Register;
import utils.CommonUtils;
import utils.Constants;
import utils.ExcelUtil;

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
    private By textBox_Password = By.xpath("//input[@id='password']");
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
    public void enterFirstName(Register register){
        enterText(textBox_FirstName, register.getFirstName());
    }
    @Step("Enter last name")
    public void enterLastName(Register register){
        enterText(textBox_LastName, register.getLastName());
    }
    @Step("Enter Date of Birth")
    public void enterDateOfBirth(Register register){
        sleep(1);
        clickElement(textBox_DateOfBirth);
        enterTextUsingActions(textBox_DateOfBirth, register.getMonth());
        enterTextUsingActions(register.getDay());
        enterTextUsingActions(register.getYear());
    }
    @Step("Enter address")
    public void enterAddress(Register register){
        enterText(textBox_Address, register.getAddress());
    }
    @Step("Enter postcode")
    public void enterPostCode(Register register){
        enterText(textBox_PostCode, register.getPostcode());
    }
    @Step("Enter city")
    public void enterCity(Register register){
        enterText(textBox_City, register.getCity());
    }
    @Step("Enter state")
    public void enterState(Register register){
        enterText(textBox_State, register.getState());
    }
    @Step("Select country")
    public void selectCountry(Register register){
        selectDropDown(drpDown_Country, register.getCountry());
    }
    @Step("Enter phone number")
    public void enterPhone(Register register){
        enterText(textBox_phone, register.getPhoneNumber());
    }
    @Step("Enter email id")
    public void enterEmail(Register register){
        enterText(textBox_Email, register.getEmail());
        ExcelUtil.updateExcelData(Constants.EXCEL_DATA_FILE_PATH, Constants.SHEET_NAME,
                "registerNewUserFormValidation", 11, register.getEmail());
        ExcelUtil.updateExcelData(Constants.EXCEL_DATA_FILE_PATH, Constants.SHEET_NAME,
                "loginTest", 11, register.getEmail());
    }
    @Step("Enter password")
    public void enterPassword(Register register){
        clickElement(textBox_Password);
        enterText(textBox_Password, register.getPassword());
    }
    @Step("Click Register button")
    public void clickRegisterButton(){
        clickElement(btn_Register);
    }
    @Step("Fill details in registration form")
    public void fillRegistrationForm(Register register){
        enterFirstName(register);
        enterLastName(register);
        enterDateOfBirth(register);
        enterAddress(register);
        enterPostCode(register);
        enterCity(register);
        enterState(register);
        selectCountry(register);
        enterPhone(register);
        enterEmail(register);
        enterPassword(register);
    }
    public int getErrorCount(){
        waitUntilNumberElementsMoreThanSize(mandatory_alert, 0);
        return getSizeOfElements(mandatory_alert);
    }
}
