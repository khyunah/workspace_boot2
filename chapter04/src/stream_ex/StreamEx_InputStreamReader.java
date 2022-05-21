package stream_ex;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx_InputStreamReader {

	public static void main(String[] args) {
		InputStream is = System.in;

		InputStreamReader ir = new InputStreamReader(is);

		char[] inputData = new char[5];
		try {
			ir.read(inputData);
			System.out.println(inputData);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
