package com.safiullah.learningspring.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static final DateFormat DATE_FORMAT	= new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date createDateFromDateString(String dateString) {
		Date date = null;
		if(dateString != null) {
			try {
				date = DATE_FORMAT.parse(dateString);
			} catch (Exception e) {
				// In case of exception just setting today's date.
				date = new Date();
			}
		}else {
			// In case of passed dateString is null, just setting today's date.
			date = new Date();
		}
		return date;
	}
	
}
