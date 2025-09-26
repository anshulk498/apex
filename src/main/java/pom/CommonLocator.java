package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonLocator {

	
	 public WebDriver driver;
	 
	 public CommonLocator(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//span[contains(.,'Test your Knowledge')]") private WebElement tyk;
	 
	 
	 public WebElement getTyk() {
		 return tyk;
	 }
	 
	 public void getClickTyk() {
	    tyk.click();
	 }
}
