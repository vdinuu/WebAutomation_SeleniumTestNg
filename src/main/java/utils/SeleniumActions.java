package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static utils.DriverFactory.getDriver;

public class SeleniumActions  {

    public static WebElement findElement(By identifier) {
        waitUntilDisplayed(identifier);
        return getDriver().findElement(identifier);
    }

    public static void waitUntilDisplayed(By identifier) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(identifier));
    }

    public static void waitUntilDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilClickable(By identifier) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(identifier));
    }

    public static void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickElement(By element){
        waitUntilClickable(element);
        findElement(element).click();
    }

    public static void clickElement(WebElement element){
        waitUntilClickable(element);
        element.click();
    }

    public static void mouseHover(By identifier){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElement(identifier)).build().perform();
    }

    public static void mouseHover(WebElement element){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    public static void enterText(By locator, String text){
        waitUntilDisplayed(locator);
        findElement(locator).sendKeys(text);
    }

    public static void enterText(WebElement element, String text){
        waitUntilDisplayed(element);
        element.sendKeys(text);
    }

    public static boolean isElementDisplayed(By locator){
        boolean flag;
        try {
            flag = findElement(locator).isDisplayed();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean isElementDisplayed(WebElement element){
        boolean flag;
        try {
            flag = element.isDisplayed();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static void switchToNewTab(){
        String parent = getDriver().getWindowHandle();
        Set<String> windows = getDriver().getWindowHandles();
        for(String window : windows){
            if(!window.equals(parent)){
                getDriver().switchTo().window(window);
                break;
            }
        }
    }

    public static void waitUntilAttributeToBe(By identifier, String attributeName, String attributeValue) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
        wait.until(ExpectedConditions.attributeToBe(identifier, attributeName, attributeValue));
    }

    public static void waitUntilAttributeToBe(WebElement element, String attributeName, String attributeValue) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
        wait.until(ExpectedConditions.attributeToBe(element, attributeName, attributeValue));
    }
    public static void jsClickElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
    public static void switchToFrame(By identifier){
        getDriver().switchTo().frame(findElement(identifier));
    }
    public static void switchToFrame(int index){
        getDriver().switchTo().frame(index);
    }
    public static void switchToFrame(String name){
        getDriver().switchTo().frame(name);
    }
    public static void switchToDefault(){
        getDriver().switchTo().defaultContent();
    }
    public static String getPageTitle(){
        return getDriver().getTitle().trim();
    }
    public static void selectDropDown(By dropdownIdentifier, String option){
        Select select = new Select(findElement(dropdownIdentifier));
        select.selectByVisibleText(option);
    }
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
        }
    }
    public static void setAttribute(By locator, String attributeName, String attributeValue){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", findElement(locator),
                attributeName, attributeValue);
    }

}
