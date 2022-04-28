package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import dto.Post;

public class HttpMainTest2 {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET"); // REST API
//			connection.setRequestProperty("Content-type", "application/json");

			// 요청할때 커넥트를 해야 함.
			connection.connect();

			// 요청이 잘 도착했는지 성공했는지 코드를 받아오는 녀석
			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer buffer = new StringBuffer();
			String line = null;

			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			} else if (statusCode == 404) {
				System.out.println("네트워크 연결이 불안정 합니다.");
			}

			String str = buffer.toString();
			System.out.println(str);

			System.out.println();

			Post post = new Post();
			// 문자열을 파싱해서 Post객체에 값을 담아 보세요
			// 잘 담겼는지 출력하기.

			System.out.println(str.length());
			post.userId = Integer.parseInt(str.substring(13, 14));
			System.out.println(post.userId);
			post.id = Integer.parseInt(str.substring(23, 25));
			System.out.println(post.id);
			post.title = str.substring(38, 72);
			System.out.println(post.title);
			post.body = str.substring(85, 301);
			System.out.println(post.body);
			
			// 굉장히 불편하기 때문에 Gson이라는 메이븐 레파짓토리를 이용한다 ( 라이브러리 )

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
