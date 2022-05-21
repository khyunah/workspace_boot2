package kha_json.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

public class HttpMainText1_Json {
	
	public static void main(String[] args) {
		try {
			
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
			
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			
			httpURLConnection.setRequestMethod("GET");
			
			httpURLConnection.connect();
			
			int stateCode = httpURLConnection.getResponseCode();
			System.out.println("jsonplaceholder으로부터 응답코드 : " + stateCode);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			String line;
			
			while((line = bufferedReader.readLine()) != null) {
				buffer.append(line);
			}
			
			Gson gson = new Gson();
			line = buffer.toString();
			
			PostDto postList = gson.fromJson(line, PostDto.class);
			System.out.println(postList.userId);
			System.out.println(postList.id);
			System.out.println(postList.title);
			System.out.println(postList.body);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
