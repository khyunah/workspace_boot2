package ch03;

public class MainTest {

	public static void main(String[] args) {
		Report report = new Report();
		
		MyReport myReport = new MyReport("홍길동", "010-0000-0000", report);
		myReport.complete();
	}
}
