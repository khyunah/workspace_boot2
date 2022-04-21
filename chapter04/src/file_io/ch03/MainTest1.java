package file_io.ch03;

import java.io.FileOutputStream;

/**
 * 
 * @author ITPS 바이트 단위 출력 / 파일에 한 바이트씩 쓰기
 */
public class MainTest1 {

	public static void main(String[] args) {

		// FileOutputStream ㅡ> 파일이 없다면 자동으로 생성해준다.
		try (FileOutputStream fos = new FileOutputStream("output_a.txt", true)) {	// true없을때는 덮어쓰는 것, true는 append기능
			// 1 파일을 있다면 있는 파일로 출력을 하게 되고, 
			// 2
			// 3
			// 4
			// 5
			fos.write(65);
			fos.write(66);
			fos.write('C');
			fos.write('D');
			fos.write('E');
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" >> 출력 처리 끝 << ");
	}
}
