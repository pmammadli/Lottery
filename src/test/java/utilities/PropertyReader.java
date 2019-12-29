package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertyReader {

	private static Properties propertyReader;
	
	static {
		try {
			FileInputStream input = new FileInputStream("config.properties");
			propertyReader = new Properties();
			propertyReader.load(input);
			input.close();
		} catch (IOException ioe) {
			throw new RuntimeException("file not found, check config file");
		}
	}
	
	public static String getProperty(String key) {
		return propertyReader.getProperty(key);
	}
}
