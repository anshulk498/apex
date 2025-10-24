package devadmin;

import java.awt.Dimension;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.Excel_Utility;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Test {

	
	
	public static void main(String[] args) throws Throwable {
//		String filepath="";
//		String sheetname="Sheet1";
//		
//		Excel_Utility eu=new Excel_Utility();
//		Map<String, String> alluser = eu.getExcelData("src/test/resources/exceldata.xlsx", "sheet1");
//		
//		for(Map.Entry<String,String> entry :alluser.entrySet()) {
//			
//			System.out.println("username:"+entry.getKey()+"password"+entry.getValue());
//		}
		
		WebDriver driver=new ChromeDriver();
		org.openqa.selenium.Dimension d=new org.openqa.selenium.Dimension(100, 200);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://admindevdatacollect.equalyz.ai/");
		System.out.println(driver.getTitle());
	//	driver.manage().window().setSize(d);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("admindc@yopmail.com");
	//	js.executeScript("arguments[0].value='admindc@yopmail.com';", email);
		WebElement password = driver.findElement(with(By.tagName("input")).below(email));
		password.sendKeys("Admin@123");
		WebElement login = driver.findElement(with(By.tagName("button")).below(password));
		login.click();
		System.out.println(login.getCssValue("color"));

		//js.executeScript("history.go(0)");
		String title = (String) js.executeScript("return document.title;");
		System.out.println(title);
		String url = (String) js.executeScript("return document.URL;");
		System.out.println(url);
		
		List<WebElement> links = driver.findElements(By.tagName("link"));
		
		for(WebElement link:links) {
			 String url1 = link.getAttribute("href");
	            String name = link.getText();
	            System.out.println(url1);
	            System.out.println(name);
		}
	}
}
