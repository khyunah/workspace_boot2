package file_io.ch02;

import java.io.FileInputStream;

public class MainTest_98 {

	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("input_kha2.txt")){
			byte[] data = new byte[10];
			int i;
			// 10개씩 읽어라
			while((i = fis.read(data)) != -1) {
				for(int j = 0; j < i; j++) {
					System.out.print((char)data[j]);
				}
				System.out.println(" / 10개 완료");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
