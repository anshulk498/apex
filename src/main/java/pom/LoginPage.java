package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Property_Utility;



public class LoginPage extends Property_Utility {
   public WebDriver driver;
   
   
	  public LoginPage(WebDriver driver) {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  
	  @FindBy(id = "email") private WebElement email;
	  @FindBy(id="password") private WebElement password;
	  @FindBy(xpath = "//button[contains(@type,'submit')]") private WebElement login;
	  
	  public WebElement getEmail() {
		return email;  
	  }
	  
	  public WebElement getPassword() {
			return password;  
		  }
	  
	  public WebElement getLogin() {
		return login; 
	  }
	  
	  public void loginToAdmin(String Email,String Password) {
		  email.sendKeys(Email);
		  password.sendKeys(Password);
		  login.click();
		  
	  }
	  
	  
}
