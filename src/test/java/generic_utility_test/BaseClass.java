package generic_utility_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.LoginPage;

public class BaseClass {
    public WebDriver driver;
    Property_Utility pu=new Property_Utility();
	@BeforeSuite
	public void BS() {
		System.out.println("database connection started");
	}

	 @BeforeTest
	 public void BT() {
		 System.out.println("ENVIRNOMENT SET UP");
	 }
	 
	 @BeforeClass
	 public void BC() throws Throwable {
		 System.out.println("BROWSER LAUNCH");
		
		String browser=pu.getKeyValue("browser");
		 String url=pu.getKeyValue("url");
		
		switch(browser.toLowerCase()) {
		
		case "chrome" :WebDriverManager.chromedriver().setup(); 
		               ChromeOptions chromeOptions = new ChromeOptions();
		               chromeOptions.addArguments("--disable-notifications");  // disables pop-ups
		               driver = new ChromeDriver(chromeOptions);
		               break;
		               
		case "edge" :  WebDriverManager.edgedriver().setup();
		               EdgeOptions edgeOptions = new EdgeOptions();
		               edgeOptions.addArguments("--disable-notifications"); // disables pop-ups
		               driver = new EdgeDriver(edgeOptions);
                       break;
		
		case "firefox" :WebDriverManager.firefoxdriver().setup();
		                FirefoxOptions firefoxOptions = new FirefoxOptions();
	                    firefoxOptions.addPreference("dom.webnotifications.enabled", false); // disables notifications
	                    driver = new FirefoxDriver(firefoxOptions);
        break;
        
        default :WebDriverManager.chromedriver().setup();
                 chromeOptions = new ChromeOptions();
                 chromeOptions.addArguments("--disable-notifications");  // disables pop-ups
                 driver = new ChromeDriver(chromeOptions);
        
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
		 System.out.println("login to app");
		 String email = pu.getKeyValue("email");
		 String password = pu.getKeyValue("password");
		 
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToAdmin(email, password);
 
	 }
    
	 @BeforeMethod
	 public void BM() throws Throwable {
//		 System.out.println("login to app");
//		 String email = pu.getKeyValue("email");
//		 String password = pu.getKeyValue("password");
//		 
//		 LoginPage lp=new LoginPage(driver);
//		 lp.loginToAdmin(email, password);
		
		 
	 }
	 
	 @AfterMethod
	 public void AM() {
		 System.out.println("logout from app");
	 }

	 @AfterClass
	 public void AC() {
		 System.out.println("BROWSER CLOSED");
	 }
	 
	 
	 @AfterTest
	 public void AT() {
		 System.out.println("CLEAN ENVIRNOMENT");
	 }
	 
	 @AfterSuite
		public void AS() {
			System.out.println("database connection closed");
		}
	 

}
