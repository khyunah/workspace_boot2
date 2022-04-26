package socket_ex.ch06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * 다중
 * 
 * @author ITPS
 *
 */
public class ServerFile {

	ServerSocket serverSocket; // 다른 클라이언트 연결 대기

	Vector<UserSocket> sockets = new Vector<>();

	public ServerFile() {

		System.out.println("1. >>>>> 서버 소켓 시작 <<<<<");
		try {
			serverSocket = new ServerSocket(10000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 새로운 소켓 생성
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				UserSocket userSocket = new UserSocket(this, socket);
				userSocket.start();

				sockets.add(userSocket);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 생성된 유저 소켓에 접근해서 하나씩 메세지 보내기
	// 방송하다 ( 전체 방송 )
	public void broadcast(String msg) {

		for (int i = 0; i < sockets.size(); i++) {
			sockets.get(i).sendMessage(msg);
		}
	}

	public static void main(String[] args) {
		new ServerFile();
	}
}
