package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver initDriver(String browser, String url, boolean headless){
        switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if(headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                tlDriver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(headless) {
                    firefoxOptions.addArguments("--headless=new");
                }
                tlDriver.set(new FirefoxDriver(firefoxOptions));
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if(headless) {
                    edgeOptions.addArguments("--headless=new");
                }
                tlDriver.set(new EdgeDriver(edgeOptions));
                break;
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.LARGE_WAIT_SECONDS));
        getDriver().get(url);
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
