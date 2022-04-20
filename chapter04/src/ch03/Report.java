package ch03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Report implements WriteReport {
	
	private String printDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		return dateFormat.format(Calendar.getInstance().getTime());
	}
	
	@Override
	public void onWriteReport(String name, String phoneNumber) {
		System.out.println("최신 수정 날짜 : " + printDate());
		System.out.println("======= Report =======");
		System.out.println();
		System.out.println(" [ 이름 ]  [ 전화번호 ]");
		System.out.println();
		System.out.println(" " + name + "  " + phoneNumber);
		System.out.println();
		System.out.println("======================");
	}
}
