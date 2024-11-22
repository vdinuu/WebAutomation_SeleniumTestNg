package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utils.DataMap;
import utils.DriverFactory;
import utils.ExcelUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static utils.DriverFactory.getDriver;

public class TestBase {

    public static Properties prop;
//    public static Map<String, String> testDataMap = new HashMap<>();
    public DriverFactory driverFactory;
    private ThreadLocal threadLocal = new ThreadLocal<>();

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setup(Method method, String browser) {
        driverFactory = new DriverFactory();
//        String headless = System.getProperty("headless")==null ? prop.getProperty("headless") :
//                System.getProperty("headless");
        driverFactory.initDriver(browser, prop.getProperty("executionEnv"),
                Boolean.getBoolean("headless"), prop.getProperty("url"));
        String name = method.getName();
        Map<String, Map<String, Object>> data = new HashMap<>();
        try {
            data = ExcelUtil.getExcelData("src/test/resources/testData/TestData.xlsx", "DataSheet");
        } catch (IOException ignored) {
        }
        if (data.containsKey(name)) {
            DataMap.testDataMap.set(data.get(name));
        }
        SoftAssert softAssert = new SoftAssert();
        threadLocal.set(softAssert);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (null != getDriver()) {
            getDriver().quit();
        }
        getSoftAssert().assertAll();
    }

    public SoftAssert getSoftAssert() {
        return (SoftAssert) threadLocal.get();
    }

}
