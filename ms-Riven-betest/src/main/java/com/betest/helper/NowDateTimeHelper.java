package com.betest.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NowDateTimeHelper {

	public static String getDateTime() {
		Date date = Calendar.getInstance().getTime(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd kk:mm:ss"); 
        return  dateFormat.format(date); 
	}
	
	public static String getDateTimeRecid() {
		Date dateLog = new Date();
		String recid = new SimpleDateFormat("yyyyMMddHHmmss.S").format(dateLog);
		return recid;
	}
	
}
