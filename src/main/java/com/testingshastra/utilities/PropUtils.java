package com.testingshastra.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public String getProperty(String filePath, String key) {
		String value = "";
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);//get(String key)
			System.out.println("Returning locator: "+value);
		} catch (FileNotFoundException e) {
			System.err.println("Unable to load file");
		} catch (IOException e) {
			System.err.println("Unable to read properties file");
			e.printStackTrace();
		}

		return value;
	}
	
	public String getLocator(String key) {
		String base = System.getProperty("user.dir");
		String locator =  getProperty(base+"/src/test/resources/OR.properties", key);
		return locator;
	}
}
