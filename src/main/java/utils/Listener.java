package utils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.startTestCase(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("Test case : "+result.getName()+" completed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.error("Exception occurred: " + result.getThrowable());
        Logs.error("************ Test Case failed************"+result.getName());
//        try {
//            TestUtil.takeScreenshotAtEndOfTest();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("**********Test case : "+result.getName()+" skipped*********");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Logs.warn("Test Failed but within success percentage" +result.getName());
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
