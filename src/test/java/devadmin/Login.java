package devadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.WebDriver_Utility;
import generic_utility_test.BaseClass;
import pom.CommonLocator;
import pom.TYK;


public class Login extends BaseClass{
	WebDriver_Utility wb=new WebDriver_Utility();
	
	@Test
	public void adminLogin() throws Throwable {
		
		
		String ExpectedURL="https://admindevdatacollect.equalyz.ai/dashboard";
		//wb.getExplicitWait(driver, ExpectedURL);
		wb.getFluentWaitForURL(driver, ExpectedURL);
		String actualurl = wb.getCurrentUrl(driver);
		Assert.assertEquals(actualurl, ExpectedURL);
		
	}
	
	@Test(dependsOnMethods = "adminLogin")
	public void createTYK() throws InterruptedException {
		TYK tyk=new TYK(driver);
		CommonLocator cm=new CommonLocator(driver);
		WebDriver_Utility wu=new WebDriver_Utility();
		wu.getFluentWaitForWebelementL(driver, cm.getTyk());
		cm.getClickTyk();
		tyk.clickOnAddTest(driver);
		Thread.sleep(1000);
		tyk.clickcategorytype(driver);
		List<WebElement> dd = tyk.getdropdownListcategorytype();
		System.out.println(dd.size());
		for(WebElement dd1:dd) {
			if(dd1.getText().equalsIgnoreCase("Spontaneous")) {
				dd1.click();
				break;
			}
		}
		System.out.println("down");
		
		driver.findElement(By.xpath("(//div[@class='ant-select-selection-overflow'])[1]")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(2000);
	
		WebElement create = driver.findElement(By.xpath("//button[@type='submit']"));
 		js.executeScript("arguments[0].scrollIntoView(true);", create);
		List<WebElement> dd3 = driver.findElements(By.xpath("(//div[contains(@class,'rc-virtual-list-holder-inner')])[2]/div/div"));
		for(WebElement ele:dd3) {
			if(ele.getText().equalsIgnoreCase("None")) {
			ele.click();
				System.out.println(ele.getText());
				break;
			}
		}
		driver.findElement(By.xpath("(//div[@class='ant-select-selection-overflow'])[2]")).click();
		
		
		Thread.sleep(3000);
		
		
		List<WebElement> dd4=driver.findElements(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[4]/div/div"));
		
		for(WebElement ele:dd4) {
			if(ele.getText().equalsIgnoreCase("None")) {
			ele.click();
				System.out.println(ele.getText());
				break;
			}
		}
		
	
	}
}
