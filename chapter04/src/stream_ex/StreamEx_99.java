package stream_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx_99 {

	public static void main(String[] args) {
		// InputStream / read()
		InputStream in = System.in;
//		try {
//			int data = in.read();
//			System.out.println(data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
		// InputStreamReader / read(byte[] b)
		InputStreamReader ir = new InputStreamReader(in);
//		try {
//			char[] data = new char[26];
//			ir.read(data);
//			System.out.println(data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// BufferedReader / readLine()
		BufferedReader br = new BufferedReader(ir);
		try {
			String data = br.readLine();
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
