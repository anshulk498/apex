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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import generic_utility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.LoginPage;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    Property_Utility pu = new Property_Utility();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite - Setup suite level resources if any");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Setup test level resources if any");
    }
     @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(@Optional("")String browserFromXml) throws Throwable {
        System.out.println("Before Class - Browser Launch & Login");
        System.out.println("BeforeClass: Starting browser setup");

        String browser;
        if (browserFromXml != null && !browserFromXml.trim().isEmpty()) {
            browser = browserFromXml;
        } else {
            browser = pu.getKeyValue("browser");
        }

        String url = pu.getKeyValue("url");
        WebDriver drv;

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                drv = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                drv = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                drv = new FirefoxDriver(firefoxOptions);
                break;

            default:
                WebDriverManager.chromedriver().setup();
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                drv = new ChromeDriver(chromeOptions);
                break;
        }

        drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        drv.manage().window().maximize();
        drv.get(url);

        driver.set(drv);  //  SET FIRST

        // NOW it's safe to log this
        System.out.println("BeforeClass: WebDriver set: " + getDriver());

        // Login before tests
        String email = pu.getKeyValue("email");
        String password = pu.getKeyValue("password");
        LoginPage lp = new LoginPage(getDriver());
        lp.loginToAdmin(email, password);
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Runs before each test method");
        // Add per-method setup if needed
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Runs after each test method");
        // Add per-method teardown if needed
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Browser Quit");
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test - Cleanup after all tests in <test> tag");
        // Add test-level cleanup if needed
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - Cleanup after all tests in suite");
        // Add suite-level cleanup if needed
    }
}
