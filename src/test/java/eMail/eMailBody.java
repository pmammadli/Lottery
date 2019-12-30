package eMail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Driver;

public class eMailBody {

	
	
	public static String winNums () {
		String numbers = "";
Driver.getDriver().get("https://www.txlottery.org/export/sites/lottery/Games/Powerball/index.html");
		
		WebElement numberList = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/ol"));
		
		List<WebElement> winningNumbers = numberList.findElements(By.tagName("li"));
		
				
		for (int i =0; i < winningNumbers.size(); i++) {
			numbers += winningNumbers.get(i).getText();
			numbers += " ";
		}
		return numbers.trim();
	}
}
