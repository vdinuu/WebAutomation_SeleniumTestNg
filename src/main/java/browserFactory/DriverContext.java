package browserFactory;

import org.openqa.selenium.WebDriver;
import utils.Constants;

import java.time.Duration;

public class DriverContext {
    private ExecutionStrategy executionStrategy;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public DriverContext(ExecutionStrategy executionStrategy){
        this.executionStrategy = executionStrategy;
    }
    public void setExecutionStrategy(ExecutionStrategy executionStrategy){
        this.executionStrategy = executionStrategy;
    }
    public void setUpDriver(String browser, String url){
        tlDriver.set(executionStrategy.setUpDriver(browser));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.MEDIUM_WAIT_SECONDS));
    }
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
