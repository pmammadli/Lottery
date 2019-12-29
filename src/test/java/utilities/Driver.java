package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

private Driver() {
		
	}
	
	private static WebDriver driver;
	
	
	//TODO - rewrite with switch, check OS for safari, IE
	public static WebDriver getDriver() {
		if (driver == null) {
			if(PropertyReader.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		
		
		return driver;
	}


	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	
}
