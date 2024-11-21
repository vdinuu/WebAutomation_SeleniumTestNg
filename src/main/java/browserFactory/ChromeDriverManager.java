package browserFactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Constants;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager implements BrowserManager {
    @Override
    public WebDriver createDriver(String env, boolean headless) {
        WebDriver driver= null;
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless=new");
        }
        if (env.equals("local")) {
            driver = new ChromeDriver(chromeOptions);
        } else if (env.equals("remote")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.WIN11);
            desiredCapabilities.setBrowserName("chrome");
            chromeOptions.merge(desiredCapabilities);
            try {
                driver = new RemoteWebDriver(new URL(Constants.HUB_URL), desiredCapabilities);
            } catch (MalformedURLException ignored) {
            }
        }
        return driver;
    }
}
