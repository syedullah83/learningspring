package com.safiullah.learningspring.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

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

/*Another Way to parse date from String. this can be used in case if we dont know in what pattern we will get the request String.

private static final String FORMAT_1 = "yyMMddHHmmssSSS";
private static final String FORMAT_2 = "yyyy-MM-dd";
private static final String FORMAT_3 = "yyyyMMdd'T'HH:mm:ss.SSS";
private static final String FORMAT_4 = "yyyyMMddHHmmss.SSS";
private static final String FORMAT_5 = "yyyyMMddHHmmss";
//private static final String FORMAT_6 = "dd/MM/yyyy";
private static final String FORMAT_7 = "dd/MMM/yyyy";
private static final String FORMAT_8 = "dd-MMM-yyyy HH:mm:ss";
private static final String FORMAT_9 = "yyyy-MM-dd HH:mm:ss.SSS";
private static final String FORMAT_10 = "MM/dd/yyyy";

public static Date getDate(String dateString){

    if(isValidDate(dateString, FORMAT_1)){
        return getDate(dateString, FORMAT_1);
    }
    if(isValidDate(dateString, FORMAT_2)){
        return getDate(dateString, FORMAT_2);
    }
    if(isValidDate(dateString, FORMAT_3)){
        return getDate(dateString, FORMAT_3);
    }
    if(isValidDate(dateString, FORMAT_4)){
        return getDate(dateString, FORMAT_4);
    }
    if(isValidDate(dateString, FORMAT_5)){
        return getDate(dateString, FORMAT_5);
    }
    if(isValidDate(dateString, FORMAT_6)){
        return getDate(dateString, FORMAT_6);
    }
    if(isValidDate(dateString, FORMAT_7)){
        return getDate(dateString, FORMAT_7);
    }
    if(isValidDate(dateString, FORMAT_8)){
        return getDate(dateString, FORMAT_8);
    }
    if(isValidDate(dateString, FORMAT_9)){
        return getDate(dateString, FORMAT_9);
    }
    if(isValidDate(dateString, FORMAT_10)){
        return getDate(dateString, FORMAT_10);
    }
    return null;
}

public static Date getDate(String dateString, String format) {

    Date date = null;
    try {
        final SimpleDateFormat datetimeFormatter = new SimpleDateFormat(format);
        if (StringUtils.isBlank(dateString)) {
            dateString = datetimeFormatter.format(new Date());
        }
        date = datetimeFormatter.parse(dateString);

    } catch (final Throwable t) {
        // log here failed to convert string.
    }
    return date;
}

public static boolean isValidDate(String inDate, String format) {
    if(StringUtils.isBlank(inDate)){
        return false;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
    	// If we get exception means this is not the format for the passed string, so we will try with another one.
      return false;
    }
    return true;
  }*/
