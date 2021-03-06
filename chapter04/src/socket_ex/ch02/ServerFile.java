package socket_ex.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	ServerSocket serverSocket;
	Socket socket;

	BufferedReader bufferedReader;

	public ServerFile() {
		System.out.println("1. >>>>> 서버 소켓 시작 <<<<<");

		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("2. 서버 소켓 생성 완료");

			socket = serverSocket.accept();
			System.out.println("3. 클라이언트 연결 완료");

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로 받은 메세지 : " + msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외발생");
		}
	}

	public static void main(String[] args) {
		new ServerFile();
	}
}
