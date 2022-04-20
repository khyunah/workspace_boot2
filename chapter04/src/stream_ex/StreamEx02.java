package stream_ex;

import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {

	public static void main(String[] args) {

		// InputStream 입력을 받는 객체
		// 키보드에 연결시켜주는 System.in
		InputStream in = System.in;

		// 데코레이터 패톤
		// 기능의 확장만 있는 InputStreamReader ( ㅡ> 바이트 단위로 읽는 기능은 없음, 생성자에 InputStream 객체
		// 넣어주기)
		// 자동으로 부호화가능, 추가적 기능
		InputStreamReader ir = new InputStreamReader(in);

		// InputStreamReader 의 단점
		// 사용자의 입력을 예상할 수 없음 ㅡ> 가변적임
		// char[] data = new char[1000];
		// 이런식으로 할 순 있지만 미리 크기가 정해져 있어야 하기 때문에
		// 낭비가 심하고 부족할 수도 있어서 통신에서 잘 사용하지 않는다.

		// 해결 방안
		// BufferedReader
		// 숫자를 자동으로 부호화 해준다.
		// 가변배열이 들어가 있어서 문자를 가변적으로 받는다. ㅡ> 낭비가 없음.

		try {
			char[] data = new char[3];
			ir.read(data);
			System.out.println(data);
		} catch (Exception e) {
			System.out.println("예외" + e.getMessage());
		}
	}
}
