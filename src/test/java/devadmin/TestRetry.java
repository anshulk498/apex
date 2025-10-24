package devadmin;

import org.testng.annotations.Test;
import generic_utility.RetryAnalyzerImplementation;
public class TestRetry {
	
	@Test(retryAnalyzer =RetryAnalyzerImplementation.class)
	public void login() {
		 System.out.println("Running test...");
		    assert false; // simulate failure
	}

}
