package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyException2 {

	String fileName;

	public MyException2(String fileName) {
		this.fileName = fileName;
	}

	public String readFile() throws IOException {
		FileInputStream fis = new FileInputStream(this.fileName);
		Properties properties = new Properties();
		properties.load(fis);
		String dbType = properties.getProperty("DBTYPE");
		return dbType;
	}
	
	public static void main(String[] args) {
		
		MyException2 exception2 = new MyException2("a.txt");
		try {
			String result = exception2.readFile();
			System.out.println("결과값 : " + result);
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("프로그램 실행중 예외가 발생하여 결과값 출력을 못함 ");
		}
		System.out.println("정상종료");
	}
}
