package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends ClientFrame {

	// 프레임 창
	private ClientFrame messageFrame;

	// 소켓 장치
	private Socket socket;

	// 입출력 장치
	private BufferedReader reader;
	private BufferedWriter writer;

	// 연결 주소
	private String ip = "127.0.0.1";
	private int port = 10000;
	
	private String name;

	public Client(String name) {
		super(name);
	}

	private void initObject() {
		// 프레임 창
		
		// 소켓 장치
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 입출력 장치
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		new Client();
	}
}
