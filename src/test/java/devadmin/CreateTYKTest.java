package devadmin;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utility.ExtentManager;
import generic_utility.WebDriver_Utility;
import generic_utility_test.BaseClass;
import pom.CommonLocator;
import pom.TYK;

import org.apache.logging.log4j.Logger;


public class CreateTYKTest extends BaseClass {
    //swtich
	private static final Logger log = LogManager.getLogger(CreateTYKTest.class);
	@Test(groups = {"smoke"}, retryAnalyzer = generic_utility_test.RetryAnalyzerImplementation.class)

	public void createTYK() throws Throwable {
		 log.info("Starting createTYK test");
		WebDriver_Utility wu=new WebDriver_Utility();
		CommonLocator cm=new CommonLocator(getDriver());
		if (getDriver() == null) {
	        throw new IllegalStateException("WebDriver instance is null!");
	    }

	    System.out.println("Waiting for Tyk element to be clickable");
		wu.getFluentWaitForWebelementL(getDriver(), cm.getTyk());
		cm.getClickTyk();
		TYK tyk=new TYK(getDriver());
		tyk.clickOnAddTest(getDriver());
		tyk.createTyk_ByAudio_Spantanous(getDriver(), "English", "Spontaneous", "this is english1", "1", "20","1","None","None", "4", "1", "1", "1");
//		wu.getFluentWaitForWebelementL(driver, tyk.getAddTest());
		wu.getExplicitWait(getDriver(), tyk.getAddTest());
		String actualToast = cm.getSuccessfullToast();
		log.info("Toast message: " + actualToast);
		String expectedToast="New Task Added Successfully";
		System.out.println(actualToast);
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(expectedToast, actualToast);
		try {
		    soft.assertAll();
		} catch (AssertionError e) {
		    ExtentManager.getTest().fail("Assertion failed: " + e.getMessage());
		    throw e; // rethrow to mark test as failed
		}
		
		log.info("createTYK test completed");
		
	}
}
