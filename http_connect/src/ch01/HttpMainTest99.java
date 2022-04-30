package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpMainTest99 {

	public static void main(String[] args) {
		try {
			// 1. 연결할 주소의 url의 객체를 준비한다.
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");

			// 2. http통신을 할 연결 객체를 생성한다. // openConnection()이 URLConnection타입이기 때문에 형변환
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			// 3. 어떤 메소드로 요청을 할 것인지 정해준다.
			httpURLConnection.setRequestMethod("GET");

			// 4. 생성한 연결 객체를 연결한다. ㅡ> 연결객체 생성후, 다양한 옵션을(3번 같은 옵션) 적용한 후 연결해준다.
			httpURLConnection.connect();

			// 5. 응답의 처리 결과의 상태를 리턴해주는 코드 // 성공하면 200번대
			int statusCode = httpURLConnection.getResponseCode();
			System.out.println("응답 코드 : " + statusCode);

			// 6. url의 정보를 읽어 오기 위해서는 스트림이 필요하다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

			// 7. 읽어온 문자열을 출력하기 위한 저장 공간
			StringBuffer sb = new StringBuffer();

			// 8. 문자열을 한줄씩 읽어오기 위해 While()사용
			if (statusCode == 200) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			}

			// 읽어온 값을 전부 출력
			System.out.println(sb);
			
			// 읽어온 값의 키값에 따른 밸류값을 필요로 할때 인덱스 번호로 문자열을 잘라준다.
			System.out.println(sb.substring(5, 7));
			System.out.println(sb.substring(10, 11));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
