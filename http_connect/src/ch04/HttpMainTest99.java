package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.UserDto;

public class HttpMainTest99 {

	public static void main(String[] args) {
		try {
			// 1. 연결할 주소의 url의 객체를 준비한다.
			URL url = new URL("https://jsonplaceholder.typicode.com/users");

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

			String line = null;

			// 8. 문자열을 한줄씩 읽어오기 위해 While()사용
			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			}

			String gsonString = sb.toString();
			
			// 배열타입을 오브젝트로 변환하기
			Type type = new TypeToken<ArrayList<UserDto>>() {}.getType();
			ArrayList<UserDto> userDtos = new Gson().fromJson(gsonString, type);
			for (UserDto userDto : userDtos) {
				System.out.println(userDto);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
