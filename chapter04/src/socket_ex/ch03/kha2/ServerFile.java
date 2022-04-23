package socket_ex.ch03.kha2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	// 소켓 장치
	ServerSocket serverSocket;
	Socket socket;
	MessageReader reader;
	MessageWriter writer;

	public ServerFile() {
		connectSocket();
		reader = new MessageReader(socket);
		writer = new MessageWriter(socket);
	}

	private void connectSocket() {
		try {
			// 소켓을 연결 해주는 역할
			serverSocket = new ServerSocket(10000);
			System.out.println("소켓 연결 대기중");

			// 연결할 소켓을 기다리다가 연결만 해주고 socket이 생성되고 나면 서버소켓과는 연결이 끊어짐
			socket = serverSocket.accept();
			System.out.println("소켓 연결 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		new ServerFile();
	}
}
