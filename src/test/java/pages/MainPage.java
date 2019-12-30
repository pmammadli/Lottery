package pages;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import eMail.CreateGmailMessage;
import utilities.Driver;
import utilities.PropertyReader;

public class MainPage {

	
	public static void main(String[] args) throws SQLException {
		if (dataChecker2()) {
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
	
	public static String currentDate() {
		Driver.getDriver().get(PropertyReader.getProperty("urlResult"));
		WebElement currentDate = Driver.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/h3"));
		String[] getOnlyDate = currentDate.getText().split(" ");
		
		return getOnlyDate[4];
	}
	
	
	public static boolean dataChecker2 () {
		boolean isNew = false;
		String queryInsert = "INSERT INTO dates ('date`) VALUES (?);";
		String querySelect = "Select * from dates;";
		Set<String> mySet = new HashSet<String>();
		try {
		 
		Statement stmt = dbConnectio().createStatement();
		ResultSet rs = stmt.executeQuery(querySelect);
		
		while (rs.next()) {
		 
		 mySet.add(rs.getString("date"));
		
			
		}
		
		dbConnectio().close();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if (!mySet.contains(currentDate())) {
			try {
				isNew = true;
			addData();
			} catch (Exception e) {
				
			}
		}
		
		return isNew;
	}
	
	public static void addData() throws Exception {
		
		String query = "INSERT INTO dates ("
				+ "`DATE`) VALUES"
				+ " (? );  ";

		PreparedStatement preparedStmt = dbConnectio().prepareStatement(query);
		
		preparedStmt.setString(1, currentDate());
		
		preparedStmt.execute();

	}
	
	
	public static Connection dbConnectio() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotterydates","root","Qwerty123456!");
		
		return con;
	}
}
