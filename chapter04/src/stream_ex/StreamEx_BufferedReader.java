package stream_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx_BufferedReader {

	public static void main(String[] args) {
		InputStream is = System.in;

		InputStreamReader ir = new InputStreamReader(is);

		BufferedReader br = new BufferedReader(ir);
		
		try {
			String inputData = br.readLine();
			System.out.println(inputData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
