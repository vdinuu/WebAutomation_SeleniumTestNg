package com.automation.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test case : "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case : "+result.getName()+" completed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Exception occurred: " + result.getThrowable());
        try {
            TestUtil.takeScreenshotAtEndOfTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case : "+result.getName()+" skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage" +result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting test case : "+context.getOutputDirectory());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method" +context.getPassedTests());
        System.out.println("This is onFinish method" +context.getFailedTests());
    }
}
