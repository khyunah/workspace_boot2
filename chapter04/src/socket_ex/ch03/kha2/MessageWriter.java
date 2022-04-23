package socket_ex.ch03.kha2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MessageWriter implements Runnable {

	Socket socket;

	// 키보드 연결
	BufferedReader keyBoardReader;

	// 출력 장치
	BufferedWriter bufferedWriter;

	public MessageWriter(Socket socket) {
		this.socket = socket;
		keyBoardReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(this).start();
	}

	@Override
	public void run() {

		try {
			while (true) {
				String msg = keyBoardReader.readLine();
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
