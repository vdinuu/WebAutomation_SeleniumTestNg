package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessExecutionStrategy implements ExecutionStrategy{
    @Override
    public WebDriver setUpDriver(String browser) {
        return switch (browser.toLowerCase().trim()){
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                yield new ChromeDriver(chromeOptions);
            }
            case "firefox" ->{
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                yield new FirefoxDriver(firefoxOptions);
            }
            case "edge" ->{
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                yield new EdgeDriver(edgeOptions);
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser.toLowerCase().trim());
        };
    }
}
