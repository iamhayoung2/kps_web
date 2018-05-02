package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeStampConvert {
	public static String getTime(int epoch) {
		String time ="";
		Date date = new Date(epoch*1000L);
		DateFormat format = new SimpleDateFormat("MMddHH");
		format.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		return format.format(date);
	}
}
