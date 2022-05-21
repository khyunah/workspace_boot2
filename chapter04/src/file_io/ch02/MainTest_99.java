package file_io.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainTest_99 {

	public static void main(String[] args) {
		try {
			FileInputStream fs = new FileInputStream("input_kha2.txt");
			char data;
			while ((data = (char) fs.read()) != -1) {
				System.out.print(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
