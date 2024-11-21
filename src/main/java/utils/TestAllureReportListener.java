package utils;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utils.DriverFactory.getDriver;

public class TestAllureReportListener implements ITestListener {
    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }
    @Attachment(type = "image/png")
    public byte[] saveFailureScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }
    @Override
    public void onTestStart(ITestResult result) {
        Logs.startTestCase(getTestMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("Test case : "+getTestMethodName(result)+" completed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.error("Exception occurred: " + result.getThrowable());
        Logs.error("************ Test Case failed************"+getTestMethodName(result));
        WebDriver driver = getDriver();
        if(driver != null){
            Logs.info("Capturing screenshot for "+getTestMethodName(result));
            String path = SeleniumActions.captureScreenshot(driver, getTestMethodName(result));
            try {
                Allure.attachment(getTestMethodName(result), new FileInputStream(path));
                Allure.getLifecycle().addAttachment(getTestMethodName(result), "image/png", ".png", new FileInputStream(path));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        saveTextLog(getTestMethodName(result)+ " failed and screenshot captured.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("**********Test case : "+getTestMethodName(result)+" skipped*********");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Logs.warn("Test Failed but within success percentage" +getTestMethodName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        Logs.info("Starting test suite : "+context.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        Logs.info("Suite execution completed. Passed tests are given below:");
        Logs.info(context.getPassedTests().toString());
        Logs.info("************Test Execution Summary************");
        Logs.info("Total # of Tests : "+context.getSuite().getAllMethods().size());
        Logs.info("# of Passed Tests : "+context.getPassedTests().size());
        Logs.info("# of Failed Tests : "+context.getFailedTests().size());
        Logs.info("# of Skipped Tests : "+context.getSkippedTests().size());
        if(context.getFailedTests().size()>0) {
            Logs.info("Suite execution completed. Failed tests are given below:");
            Logs.info(context.getFailedTests().toString());
        }else{
            Logs.info("No tests failed");
        }
        Logs.info("*********************************************");
    }


}
