package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalExecutionStrategy implements ExecutionStrategy{
    @Override
    public WebDriver setUpDriver(String browser) {
        WebDriver driver =
        switch (browser.toLowerCase().trim()){
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new IllegalStateException("Unexpected value: " + browser.toLowerCase().trim());
        };
        return driver;
    }
}
