package socket_ex.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	/**
	 * 두개가 필요한 이유<br>
	 * 1. 실행되는 서버 소켓 ㅡ> 연결만 받는다. ( 연결만 해주고 연결되면 연결을 끊고 다른 연결 기다림 )<br>
	 * 2. 실행되는 클라이언트 소켓<br>
	 * 3. 둘 사이 연결 시도 ( 바이트 스트림으로 연결 )<br>
	 * 4. 새로운 소켓을 생성 <br>
	 * 1024 ~ 65535 까지중 사용하지 않는 포트 번호를 랜덤으로 생성해준다.<br>
	 * 
	 * 
	 */
	// 소켓 사용시 두개가 필요
	ServerSocket serverSocket;
	Socket socket;

	BufferedReader bufferedReader;

	public ServerFile() {
		System.out.println("1. >>>>> 서버 소켓 시작 <<<<<");

		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("2. 서버 소켓 생성 완료");

			// 클라이언트 연결 대기하는 녀석
			socket = serverSocket.accept();
			System.out.println("3. 클라이언트 연결 완료");

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String msg = bufferedReader.readLine();
			System.out.println("4. 클라이언트로 받은 메세지 : " + msg);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외발생");
		}
	}

	public static void main(String[] args) {
		new ServerFile();
	}
}
