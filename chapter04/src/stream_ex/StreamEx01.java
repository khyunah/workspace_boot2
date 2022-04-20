package stream_ex;

import java.io.InputStream;

public class StreamEx01 {

	public static void main(String[] args) {

		// InputStream 입력을 받는 객체
		// 키보드에 연결시켜주는 System.in
		InputStream in = System.in;

		// 1. 키보드에 A를 입력하면 인코딩해서 01000001로 컴퓨터에게 전송을 했음.
		// 2. ByteStream으로 흘러들어간다 ( 컴퓨터 입장에서 Input )
		// 3. read() 메서드로 01000001 ㅡ> 65로 디코딩 한다.
		// 4. 부호화 65를 문자형으로 변환.
		// InputStream 의 단점 : 1byte만 받는다. ( 문자열을 입력해도 맨앞의 문자 하나만 전송이 된다. )

		// 모든 통신에는 항상 인코딩과 디코딩이 일어난다.

		try {
			int data = in.read();
			System.out.println(data); // 인코딩
			System.out.println((char) data); // 디코딩 ( 부호화 )
		} catch (Exception e) {
			System.out.println("예외" + e.getMessage());
		}
	}
}
