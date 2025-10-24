package devadmin;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

}
