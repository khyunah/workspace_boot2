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

import dto.MoviesDto;

public class HttpMainTest99 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://yts.mx/api/v2/list_movies.json");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			
			int statusCode = connection.getResponseCode();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String lineString = null;
			
			if ( statusCode == 200) {
				while ((lineString = reader.readLine()) != null) {
					sb.append(lineString);
				}
			}
			
			lineString = sb.toString();
			
			MoviesDto moviesDto = new Gson().fromJson(lineString, MoviesDto.class);
			System.out.println(moviesDto);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
