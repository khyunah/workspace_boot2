package stream_ex;

import java.io.IOException;
import java.io.InputStream;

public class StreamEx_InputStream {

	public static void main(String[] args) {
		InputStream is = System.in;
		
		try {
			System.out.println(is.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
