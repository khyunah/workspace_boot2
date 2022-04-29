package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Post;
import dto.TodosDto;

public class HttpMainTest3 {

	public static void main(String[] args) {
		// HTTP 통신을 하기 위한 기본적인 문법

		try {
			// 준비물 1
			URL url = new URL("https://jsonplaceholder.typicode.com/todos");
			// 준비물 2
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 부가적인 정보를 추가해서 보내기
			connection.setRequestMethod("GET"); // 통신방식 인데 GET이라는 방식으로 보낼거야.
			// 연결후에 부가적인 정보를 추가해서 보내면 오류가 난다.
			connection.connect(); // 이 URL에서 참조하는 리소스에 대한 통신 링크를 엽니다

			// 100, 200, 300, 400, 500 번대의 종류가 있다 정도만 알아두기.
			int statusCode = connection.getResponseCode(); // 응답하는 코드

			// 통신이 정상적으로 완료되었어 하면 코드 200 출력
//			System.out.println(statusCode);

			// HTTP 통신할때 스트림을 달아야 한다
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer sb = new StringBuffer();
			String line = null;

			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			}

			// 사이트에 저장되어 있는 값을 그대로 출력
			String str = sb.toString();
			
			Type type = new TypeToken<ArrayList<TodosDto>>() {}.getType();
			ArrayList<TodosDto> todos = new Gson().fromJson(str, type);
			for (TodosDto todosDto : todos) {
				System.out.println(todosDto);
				System.out.println();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
