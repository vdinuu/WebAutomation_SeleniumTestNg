package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
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
    public static Map<String, String> testDataMap = new HashMap<>();
    public DriverFactory driverFactory;
    private SoftAssert softAssert;
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

    @BeforeMethod
    public void setup(Method method){
        driverFactory = new DriverFactory();
        driverFactory.initDriver(prop.getProperty("browser"), prop.getProperty("url") );
        String name = method.getName();
        Map<String, Map<String, String>> data = new HashMap<>();
        try {
            data = ExcelUtil.getExcelData("src/test/resources/testData/TestData.xlsx", "DataSheet");
        } catch (IOException e) {
        }
        if(data.containsKey(name)){
            testDataMap = data.get(name);
        }
        softAssert = new SoftAssert();
        threadLocal.set(softAssert);
    }

    @AfterMethod
    public void tearDown(){
        if(null != getDriver()){
            getDriver().quit();
        }
        getSoftAssert().assertAll();
    }
    public SoftAssert getSoftAssert(){
        return (SoftAssert) threadLocal.get();
    }

}
