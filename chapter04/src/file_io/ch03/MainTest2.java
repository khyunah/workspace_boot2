package file_io.ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 
 * @author ITPS 바이트 단위 출력 / 파일에 한 바이트씩 쓰기
 * byte[] 배열 A-Z까지 넣고 한번에 파일에 쓰기 
 */
public class MainTest2 {

	public static void main(String[] args) throws FileNotFoundException {

		FileOutputStream fos = new FileOutputStream("output_b.txt", true);
		
		try (fos) {
			byte[] bs = new byte[26];
			byte data = 65;	// A
			
			// 배열에 A-Z를 담는 작업
			for(int i = 0; i < bs.length; i++) {
				bs[i] = data;
				data++;
			}
			
			// 배열에 담겨 있는 데이터를 한번에 출력
			fos.write(bs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(" >> 출력 처리 끝 << ");
	}
}
