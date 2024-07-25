package utility;

import java.util.Date;

public class DateUtility {
	public static String getStringDate() {
		//Retrieves the current date using the Date class.
		Date localdate = new Date();
		//Returns the formatted date as a string.
		return localdate.toString().replace(":", "_").replace(" ", "_");
	}
}
