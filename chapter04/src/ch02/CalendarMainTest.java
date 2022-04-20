package ch02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarMainTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();

		// 현재 시간 ( 1000분의 1초 ) ㅡ> 영어권, 유럽, 아시아 표기법이 다르기 때문에 이렇게 설계
		System.out.println(calendar.getTimeInMillis());

		// 보기 불편한 형식을 편하게 변환해서 사용하는 방법 알아보기 ! !
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String date = dateFormat.format(calendar.getTimeInMillis());
		
		System.out.println(date);
	}
}
