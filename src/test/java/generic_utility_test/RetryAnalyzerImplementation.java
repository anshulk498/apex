package generic_utility_test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzerImplementation implements IRetryAnalyzer {

    private int retryCount = 0;        // how many times retried
    private static final int maxRetryCount = 2;  // retry twice max

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test " + result.getName() + " again, count = " + retryCount);
            return true;  // retry
        }
        return false; // stop retrying
    }
}
