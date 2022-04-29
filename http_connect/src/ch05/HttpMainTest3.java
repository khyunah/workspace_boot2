package ch05;

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

/**
 * https://yts.mx/api/v2/list_movies.json<br>
 * 연습 하기
 * 
 * @author ITPS
 *
 */
public class HttpMainTest3 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://yts.mx/api/v2/list_movies.json");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int statusCode = connection.getResponseCode();
			System.out.println(statusCode);

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
			System.out.println(str);

			// 자바 오브젝트로 변환
			Yts yts = new Gson().fromJson(str, Yts.class);
			System.out.println(yts.getData().getMovieCount());

			// 자바 오브젝트로 변환
//			Type type = new TypeToken<ArrayList<Yts>>() {}.getType();
//			ArrayList<Yts> yts2 = new Gson().fromJson(str, type);
//			for (Yts yts3 : yts2) {
//				System.out.println(yts3);
//				System.out.println();
//			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
