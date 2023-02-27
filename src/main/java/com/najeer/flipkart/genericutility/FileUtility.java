package com.najeer.flipkart.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to read common data.
 * @author Najeer
 *
 */

public class FileUtility {

/**
 * This method is used to read common data from properties file.
 * @author Najeer
 * @param key
 * @return
 * @throws IOException
 */
	public String readPropertyFileData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Flipkart_Assignment\\TestResources\\testdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
