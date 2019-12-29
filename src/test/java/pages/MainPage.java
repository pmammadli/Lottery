package pages;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import eMail.CreateGmailMessage;
import utilities.Driver;
import utilities.PropertyReader;

public class MainPage {

	
	public static void main(String[] args) {
		if (dateChecker()) {
		CreateGmailMessage.main(args);
		}
	}
	
	
	public static boolean dateChecker() {
		boolean newDates = false;
		Driver.getDriver().get(PropertyReader.getProperty("urlResult"));
		String startDate = "12/25/2019";
		WebElement currentDate = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/h3"));
		
		String[] getOnlyDate = currentDate.getText().split(" ");
		
		Set<String> setOfDates = new HashSet<String>();
		setOfDates.add(startDate);
		if (!setOfDates.contains(getOnlyDate[4])) {
			setOfDates.add(getOnlyDate[4]);
			newDates = true;
		}
		
		return newDates;
	}
	
}
