package com.najeer.flipkart.genericutility;

import java.time.LocalDateTime;

/**
 * This class is used to get the data from Java library.
 * @author Najeer
 *
 */
public class JavaUtility {

/**
 * This method is used to get the current date and time of machine.
 * @return timeStamp
 */
	public String timeStamp() {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
	}
}
