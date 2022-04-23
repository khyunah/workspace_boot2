package socket_ex.ch02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 입력 여러번 받기<br>
 * while문 사용
 * @author ITPS
 *
 */
public class ClientFile {

	Socket socket;
	BufferedWriter bufferedWriter;

	final String IP = "127.0.0.1";
	final int PORT = 10000;

	BufferedReader keybordBufferedReader;

	public ClientFile() {

		try {
			System.out.println("1. 클라이언트 소켓 시작");
			socket = new Socket(IP, PORT);

			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println("3. 키보드 버퍼 연결");
			keybordBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("4. 키보드 입력 대기");
				String msg = keybordBufferedReader.readLine();

				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientFile();
	}
}
