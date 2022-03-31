package ch12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyException {

	String fileName;

	public MyException(String fileName) {
		this.fileName = fileName;
	}

	// throws는 사용하는데에서(개발자) 예외처리해라 라고 던지는 것
	public String readFile() throws IOException {
		FileInputStream fis = new FileInputStream(this.fileName);
		Properties properties = new Properties();
		properties.load(fis);
		String dbType = properties.getProperty("DBTYPE"); // DBTYPE라는 키값이 있으면 밸류값을 읽어라
		return dbType;
	}

	public static void main(String[] args) {
		String dbType = null;
		MyException my = new MyException("b.txt");

		try {
			dbType = my.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("결과값 : " + dbType);
	} // end of main
} // end of class
