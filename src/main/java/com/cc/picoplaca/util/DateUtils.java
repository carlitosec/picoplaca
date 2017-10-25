/**
 * 
 */
package com.cc.picoplaca.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ccarrillo
 *
 */
public class DateUtils {
	
	private DateUtils(){}
	
	/**
	 * method to get the day of the week from a date
	 * 
	 * @param date 
	 * @return day of the week <1> -> Sunday
	 * 	<2> -> Monday, <3> -> Tuesday, <4> -> Wednesday, 
	 * 	<5> -> Thursday, <6> -> Friday, <7> -> Saturday 
	 */
	public static Integer getDayOfWeekFromDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
		try {
			Date convertDate = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(convertDate);
			return calendar.get(Calendar.DAY_OF_WEEK);
			
		} catch (ParseException e) {
			return -1;
		} 
	}
	
	/**
	 * method to get a parsed time
	 * 
	 * @param time
	 * @return parsed time
	 */
	public static Time getParsedTime (String time) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.TIME_FORMAT);
		try {
			return new Time(sdf.parse(time).getTime());
		} catch (ParseException e) {
			return null;
		}
	}

}
