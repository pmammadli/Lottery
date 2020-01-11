package email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Driver;
import utilities.PropertyReader;

public class EmailSubject {

	
	
	
	
	public static String subjectLine() {
		Driver.getDriver().get(PropertyReader.getProperty("urlResult"));
		WebElement emailSubject = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/h3"));
		
		String subjectLine = emailSubject.getText();
		
		return subjectLine;
		
	}
	
}
