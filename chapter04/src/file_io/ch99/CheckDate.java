package file_io.ch99;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Calendar클래스로 인스턴스를 들고와 날짜와 시간을 표현한 클래스<br>
 * 
 * @author 김현아
 *
 */
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
