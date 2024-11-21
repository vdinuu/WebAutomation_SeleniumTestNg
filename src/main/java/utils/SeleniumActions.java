package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
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
        } catch (InterruptedException ignored) {
        }
    }
    public static void setAttribute(By locator, String attributeName, String attributeValue){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", findElement(locator),
                attributeName, attributeValue);
    }

    public static int getSizeOfElements(By identifier) {
        return getDriver().findElements(identifier).size();
    }
    public static void waitUntilNumberElementsMoreThanSize(By identifier, int size) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(identifier, size));
        } catch (Exception ignored) {
        }
    }
    public static List<WebElement> findElements(By identifier){
        waitUntilNumberElementsMoreThanSize(identifier, 0);
        return getDriver().findElements(identifier);
    }
    public static void enterTextUsingActions(String text){
        Actions actions = new Actions(getDriver());
        actions.sendKeys(text).build().perform();
    }
    public static void enterTextUsingActions(By locator, String text){
        Actions actions = new Actions(getDriver());
        actions.sendKeys(findElement(locator), text).build().perform();
    }
    public static String getTimeStamp(String dateFormat){
        return new SimpleDateFormat(dateFormat).format(new Date());
    }
    @Attachment
    public static String captureScreenshot(WebDriver driver, String screenshotName){
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots"+File.separator+screenshotName+getTimeStamp("yyyy_MM_dd_HH_mm_ss")+".png");
        try {
            FileUtils.copyFile(source, screenshot);
            return screenshot.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
