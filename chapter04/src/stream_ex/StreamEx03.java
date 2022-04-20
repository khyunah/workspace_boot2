package stream_ex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

// 통신에는 항상 인코딩 디코딩이 들어간다. ( 좋은코드에는 버퍼가 달려있다. )
public class StreamEx03 {

	public static void main(String[] args) {

		// InputStream 입력을 받는 객체
		// 키보드에 연결시켜주는 System.in
		InputStream in = System.in;

		// 데코레이터 패톤
		InputStreamReader ir = new InputStreamReader(in);

		// 기능을 좀더 확장 ㅡ> 데코레이터 패톤
		// String으로 받을 수 있다.
		// 자동으로 부호화
		BufferedReader br = new BufferedReader(ir);

		try {
			String data = br.readLine();
			System.out.println(data);
		} catch (Exception e) {
			System.out.println("예외" + e.getMessage());
		}
	}
}
