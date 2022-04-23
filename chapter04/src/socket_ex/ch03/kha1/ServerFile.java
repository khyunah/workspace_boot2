package socket_ex.ch03.kha1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	// 소켓 장치
	ServerSocket serverSocket;
	Socket socket;

	// 소켓 통신의 입출력 장치
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;

	// 키보드 입력 장치
	BufferedReader keyBoardReader;

	public ServerFile() {
		connectSocket();
	}

	private void connectSocket() {
		try {
			// 소켓을 연결 해주는 역할
			serverSocket = new ServerSocket(10000);
			System.out.println("소켓 연결 대기중");

			// 연결할 소켓을 기다리다가 연결만 해주고 socket이 생성되고 나면 서버소켓과는 연결이 끊어짐
			socket = serverSocket.accept();
			System.out.println("소켓 연결 완료");

			// 메세지를 보낼 소켓
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.println("메세지 출력 소켓 연결 완료");

			// 키보드와 스트림연결
			keyBoardReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("키보드 연결 완료");

			// 메세지 읽어들일 소켓
			ConnectReader connectReader = new ConnectReader();
			Thread thread = new Thread(connectReader);
			thread.start();

			while (true) {
				String msg = keyBoardReader.readLine();

				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}

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
					System.out.println("클라이언트가 보낸 메세지 : " + msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new ServerFile();
	}
}
