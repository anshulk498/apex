package generic_utility_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import generic_utility.ExtentManager;
import generic_utility.WebDriver_Utility;

public class ListnerImplementation implements ITestListener {

    private static final Logger log = LogManager.getLogger(ListnerImplementation.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test started: " + result.getName());
        ExtentManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test passed: " + result.getName());
        ExtentManager.getTest().log(Status.PASS, "Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test failed: " + result.getName());
        ExtentManager.getTest().log(Status.FAIL, "Test failed: " + result.getName());
        ExtentManager.getTest().log(Status.FAIL, result.getThrowable());

        try {
            String details = result.getThrowable().getMessage();
            ExtentManager.getTest().fail("Failure details: " + details);

            // Take screenshot
            WebDriver_Utility wu = new WebDriver_Utility();
            String screenshotPath = wu.takeScreenshot(BaseClass.getDriver(), result.getName());

            if (screenshotPath != null) {
                ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
                log.info("Screenshot captured at: " + screenshotPath);
            }
        } catch (Exception e) {
            log.error("Error capturing screenshot", e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test skipped: " + result.getName());
        ExtentManager.getTest().log(Status.SKIP, "Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("All tests finished: " + context.getName());
        ExtentManager.flushReports();
    }
}
