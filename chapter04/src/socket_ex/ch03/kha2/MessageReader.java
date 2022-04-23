package socket_ex.ch03.kha2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageReader implements Runnable {

	Socket socket;

	// 입력 장치
	BufferedReader bufferedReader;

	public MessageReader(Socket socket) {
		this.socket = socket;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				String msg = bufferedReader.readLine();
				System.out.println("상대가 보낸 메세지 : " + msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
