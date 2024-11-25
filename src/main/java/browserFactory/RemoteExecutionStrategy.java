package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Constants;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteExecutionStrategy implements ExecutionStrategy{
    @Override
    public WebDriver setUpDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase().trim()){
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("browserName", browser.toLowerCase().trim());
                try {
                    driver = new RemoteWebDriver(new URL(Constants.HUB_URL), chromeOptions);
                } catch (MalformedURLException ignored) {
                }
            }
            case "firefox" ->{
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("browserName", browser.toLowerCase().trim());
                try {
                    driver = new RemoteWebDriver(new URL(Constants.HUB_URL), firefoxOptions);
                } catch (MalformedURLException ignored) {
                }
            }
            case "edge" ->{
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("browserName", "MicrosoftEdge");
                try {
                    driver = new RemoteWebDriver(new URL(Constants.HUB_URL), edgeOptions);
                } catch (MalformedURLException ignored) {
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser.toLowerCase().trim());
        };
        return driver;
    }
}
