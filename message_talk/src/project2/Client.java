package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

public class Client implements CallBackService {
	
	// 프레임 창
	private ClientFrame clientFrame;
	
	// 사용자 이름, 룸이름 벡터 만들기
//	private Vector<E>

	// 소켓 장치
	private Socket socket;

	// 입출력 장치
	private BufferedReader reader;
	private BufferedWriter writer;

	// 연결 주소
	private String ip = "127.0.0.1";
	private int port = 10000;
	
	public Client() {
		clientFrame = new ClientFrame(this);
	}

	private void connectNetwork() {
		try {
			
			// 소켓 장치
			socket = new Socket(ip, port);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void connectIO() {
		try {
			
			// 입출력 장치
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(String messageText) {
		try {
			writer.write(messageText + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectServer(String ip, int port, String id) {
		try {
			connectNetwork();
			connectIO();
			writer.write(ip + "/" + port + "/" + id + "\n");
			writer.flush();
			System.out.println("클라이언트 입력 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
