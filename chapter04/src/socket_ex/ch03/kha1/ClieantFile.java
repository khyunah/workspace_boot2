package socket_ex.ch03.kha1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClieantFile {

	// 소켓 장치
	Socket socket;
	final String IP = "127.0.0.1";
	final int PORT = 10000;

	// 입출력 장치
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;

	// 키보드 연결
	BufferedReader keyBoarReader;

	public ClieantFile() {
		connectSoket();
	}

	private void connectSoket() {
		try {
			socket = new Socket(IP, PORT);
			System.out.println("소켓 연결 완료");

			// 메세지 보낼 소켓
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.println("출력 소켓 연결 완료");

			// 키보드 연결
			keyBoarReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("키보드 연결 완료");

			ConnectReader connectReader = new ConnectReader();
			Thread thread = new Thread(connectReader);
			thread.start();

			while (true) {
				String msg = keyBoarReader.readLine();

				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ConnectReader implements Runnable {

		@Override
		public void run() {
			while (true) {

				try {
					bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

					String msg = bufferedReader.readLine();
					System.out.println("서버가 보낸 메세지 : " + msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ClieantFile();
	}
}
