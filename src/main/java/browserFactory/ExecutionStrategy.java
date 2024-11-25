package browserFactory;

import org.openqa.selenium.WebDriver;

public interface ExecutionStrategy {
    WebDriver setUpDriver(String browser);
}
