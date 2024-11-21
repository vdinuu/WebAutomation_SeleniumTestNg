package utils;

import browserFactory.BrowserManager;
import browserFactory.ChromeDriverManager;
import browserFactory.EdgeDriverManager;
import browserFactory.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public void initDriver(String browser, String env, boolean headless, String url) {
        BrowserManager browserManager = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriverManager();
            case "firefox" -> new FirefoxDriverManager();
            case "edge" -> new EdgeDriverManager();
            default -> throw new IllegalStateException("Unexpected value: " + browser.toLowerCase());
        };
        tlDriver.set(browserManager.createDriver(env, headless));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
    }
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
