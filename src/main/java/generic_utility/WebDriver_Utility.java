package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void getExplicitWait(WebDriver driver,String url) {
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(5));
		wb.until(ExpectedConditions.urlToBe(url));
		
	}
	
	public void getExplicitWait(WebDriver driver,WebElement ele) {
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(5));
		wb.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public static String takeScreenshot(WebDriver driver,String screenshotName) {
		try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		// Add timestamp to avoid overwriting
        String timestamp = LocalDateTime.now().toString().replace(":", "-").replace(".", "-");
        String path = "./Screenshots/" + screenshotName + "_" + timestamp + ".png";
		File dest=new File(path);
		
	
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();
		} catch (IOException e) {
		
			e.printStackTrace();
			System.out.println("Error while taking screenshot: " + e.getMessage());
            return null;
		}
	}
	
	
	public void getFluentWaitForURL(WebDriver driver, String expectedUrl) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))       // maximum wait time
                .pollingEvery(Duration.ofSeconds(1))       // check every 1 second
                .ignoring(NoSuchElementException.class);   // ignore exceptions while waiting

        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().equals(expectedUrl);
            }
        });
    }
			public WebElement getFluentWaitForWebelementL(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))       // maximum wait time
                .pollingEvery(Duration.ofSeconds(1))       // check every 1 second
                .ignoring(NoSuchElementException.class);   // ignore exceptions while waiting

        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
        
       
    }
			 public void dropdownHandling(WebDriver driver,List<WebElement> dd,String text)  {
		        
				   
				 
				 for(WebElement ele:dd) {
					System.out.println(ele.getText());
					 if(ele.getText().equalsIgnoreCase(text)) {
						ele.click();
						break;
					 }
					 
					 
				 }
				 System.out.println("--------------");
		        }
			 
			 
			 
			 public void moveToElement(WebDriver driver,WebElement ele) {
				 Actions act=new Actions(driver);
				 act.moveToElement(ele).perform();
				 
			 }
	
	
	}


