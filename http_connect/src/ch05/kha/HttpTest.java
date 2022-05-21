package ch05.kha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://yts.mx/api/v2/list_movies.json");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int responseCode = connection.getResponseCode();
			System.out.println("응답코드 : " + responseCode);

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer sb = new StringBuffer();
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			Gson gson = new Gson();
			Type type = new TypeToken<MovieDto>() {}.getType();
			MovieDto arrayList = gson.fromJson(sb.toString(), type);
			System.out.println(arrayList);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
