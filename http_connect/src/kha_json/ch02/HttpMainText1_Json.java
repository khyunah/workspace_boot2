package kha_json.ch02;

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

public class HttpMainText1_Json {
	
	public static void main(String[] args) {
		try {
			
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			
			httpURLConnection.setRequestMethod("GET");
			
			httpURLConnection.connect();
			
			int stateCode = httpURLConnection.getResponseCode();
			System.out.println("jsonplaceholder으로부터 응답코드 : " + stateCode);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			String line = null;
			
			while((line = bufferedReader.readLine()) != null) {
				buffer.append(line);
			}
			
			Type type = new TypeToken<ArrayList<PostDto>>() {}.getType();
			Gson gson = new Gson();
			ArrayList<PostDto> arrayList = gson.fromJson(buffer.toString(), type);
			
			for (PostDto postDto : arrayList) {
				System.out.println(postDto);
				System.out.println();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
