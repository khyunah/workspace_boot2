package file_io.ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainTest_99 {

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("output_kha.txt");
		
		try(fos){
			byte[] data = new byte[26];
			byte i = 65;
			for (int j = 0; j < data.length; j++) {
				data[j] = i;
				i++;
			}
			fos.write(data);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
//		try(FileOutputStream fos = new FileOutputStream("output_kha.txt")){
//			fos.write('A');
//			fos.write('B');
//			fos.write(68);
//			fos.write(69);
//			fos.write(70);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
		System.out.println("출력 끝");
	}
}
