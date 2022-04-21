package file_io.ch99;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckDate {

	private Calendar calendar;
	private DateFormat dateFormat;
	
	public CheckDate() {
		initObject();
	}
	
	private void initObject() {
		calendar = Calendar.getInstance();
		dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	}
	
	public String checkDate() {
		return dateFormat.format(calendar.getTimeInMillis());
	}
}
