package com.agc.sel.listeners;

import com.agc.sel.baseutilities.BaseClass;
import com.agc.sel.extentReport.ExtentReport;
import com.agc.sel.loggers.Logger4j;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.IAnnotationTransformer;

public class MonitorListener extends BaseClass implements ITestListener, IAnnotationTransformer {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        Logger4j.info("Test Started: " + testName);

        try {
            if (ExtentReport.getExtent() == null) {
                ExtentReport.initReports(BaseClass.driver);
                Logger4j.info("ExtentReport initialized in onTestStart()");
            }
        } catch (Throwable e) {
            Logger4j.error("Error initializing ExtentReport: " + e.getMessage());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        Logger4j.info("Test Passed: " + testName);

        ExtentReport.passed_test(testName, BaseClass.author, BaseClass.category, BaseClass.device, BaseClass.driver);
        ExtentReport.passmessage(testName + " - Test Passed successfully.");
        try {
            ExtentReport.flushReport();
            Logger4j.info("ExtentReport flushed after test success.");
        } catch (Exception e) {
            Logger4j.error("Error flushing ExtentReport after test success: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        String failureMessage = result.getThrowable() != null ? result.getThrowable().toString() : "No error message";

        Logger4j.info("Test Failed: " + testName);
        Logger4j.info("Failure Reason: " + failureMessage);

        ExtentReport.failed_test(testName, failureMessage, BaseClass.author, BaseClass.category, BaseClass.device, BaseClass.driver);
        try {
            ExtentReport.flushReport();
            Logger4j.info("ExtentReport flushed after test failure.");
        } catch (Exception e) {
            Logger4j.error("Error flushing ExtentReport after test failure: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Logger4j.info("Test Skipped: " + testName);
        ExtentReport.failmessage("Test Skipped: " + testName);
        try {
            ExtentReport.flushReport();
            Logger4j.info("ExtentReport flushed after test skipped.");
        } catch (Exception e) {
            Logger4j.error("Error flushing ExtentReport after test skipped: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        Logger4j.info("Test suite finished. Flushing ExtentReport...");
        try {
            ExtentReport.flushReport();
            Logger4j.info("ExtentReport flushed successfully.");
        } catch (Exception e) {
            Logger4j.error("Error flushing ExtentReport: " + e.getMessage());
        }
    }
}
