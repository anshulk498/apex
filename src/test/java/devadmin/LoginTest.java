package devadmin;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.WebDriver_Utility;
import generic_utility_test.BaseClass;
import pom.CommonLocator;
import pom.TYK;


public class LoginTest extends BaseClass{
	WebDriver_Utility wb=new WebDriver_Utility();
	private static final Logger log = LogManager.getLogger(LoginTest.class);
	@Test(groups = {"smoke"})
	public void adminLogin() throws Throwable {
		//anshul
		
		String ExpectedURL="https://admindevdatacollect.equalyz.ai/dashboard";
		//wb.getExplicitWait(driver, ExpectedURL);
		wb.getFluentWaitForURL(getDriver(), ExpectedURL);
		String actualurl = wb.getCurrentUrl(getDriver());
		Assert.assertEquals(actualurl, ExpectedURL);
		
	}
	
//	@Test(dependsOnMethods = "adminLogin")
//	public void createTYK() throws InterruptedException {
//		TYK tyk=new TYK(getDriver());
//		CommonLocator cm=new CommonLocator(getDriver());
//		WebDriver_Utility wu=new WebDriver_Utility();
//		wu.getFluentWaitForWebelementL(getDriver(), cm.getTyk());
//		cm.getClickTyk();
//		tyk.clickOnAddTest(getDriver());
//		Thread.sleep(1000);
//		tyk.clickcategorytype(getDriver());
//		List<WebElement> dd = tyk.getdropdownListcategorytype();
//		System.out.println(dd.size());
//		for(WebElement dd1:dd) {
//			if(dd1.getText().equalsIgnoreCase("Spontaneous")) {
//				dd1.click();
//				break;
//			}
//		}
		
	
//	}
}
