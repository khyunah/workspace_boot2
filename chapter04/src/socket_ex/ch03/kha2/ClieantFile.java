package socket_ex.ch03.kha2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClieantFile {

	// 소켓 장치
	Socket socket;
	final String IP = "127.0.0.1";
	final int PORT = 10000;
	
	MessageReader reader;
	MessageWriter writer;

	public ClieantFile() {
		connectSoket();
		reader = new MessageReader(socket);
		writer = new MessageWriter(socket);
	}

	private void connectSoket() {
		try {
			socket = new Socket(IP, PORT);
			System.out.println("소켓 연결 완료");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		new ClieantFile();
	}
}
