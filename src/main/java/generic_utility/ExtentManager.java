package generic_utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Get ExtentReports instance
    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    // Create a test in report
    public static ExtentTest createTest(String name) {
        ExtentTest extentTest = getInstance().createTest(name);
        test.set(extentTest);
        return extentTest;
    }

    // Get the current test
    public static ExtentTest getTest() {
        return test.get();
    }

    // Flush the report
    public static void flushReports() {
        getInstance().flush();
    }
}
