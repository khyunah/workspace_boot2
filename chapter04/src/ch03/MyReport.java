package ch03;

public class MyReport {
	
	WriteReport onReport;
	String name;
	String phoneNumber;
	
	public MyReport(String name, String phoneNumber, WriteReport onReport) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.onReport = onReport;
	}
	
	public void complete() {
		onReport.onWriteReport(name, phoneNumber);
	}
}
