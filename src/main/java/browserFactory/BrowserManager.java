package browserFactory;

import org.openqa.selenium.WebDriver;

/**
 * Manages the creation of WebDriver instances for different browser types.
 * This interface defines the contract for browser initialization and configuration
 * in the test automation framework.
 *
 * @author Dinu Vijayan
 */
public interface BrowserManager {
    WebDriver createDriver(String env, boolean headless);
}
