package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * 벡터 만들기
 * 
 * @author UserK
 *
 */
public class Server implements CallBackService {

//	private Vector<E>

	// 프레임 창
	private ServerFrame serverFrame;

	// 소켓 장치
	private ServerSocket serverSocket;
	private Socket socket;

	// 입출력 장치
	private BufferedReader reader;
	private BufferedWriter writer;

	public Server() {
		serverFrame = new ServerFrame(this);
	}

	/**
	 * 포트번호 입력하고 버튼 누르면 포트번호로 서버 시작.
	 */
	private void connectNetwork() {
		try {
			// 서버 소켓 장치
			serverSocket = new ServerSocket(10000);
			serverFrame.getMainBoard().append("[알림] 서버 시작");
			connectClient();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "알림", JOptionPane.ERROR_MESSAGE);
			serverFrame.getConnectBtn().setEnabled(true);
		}
	}

	/**
	 * 서버 대기하여 소켓 연결을 하고, 스레드 만들기
	 */
	private void connectClient() {
		try {
			// 소켓 장치
			socket = serverSocket.accept();
			serverFrame.getMainBoard().append("[알림] 사용자 접속 대기");
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ConnectedUser {
		Socket socket;
		
		public ConnectedUser(Socket socket) {
			this.socket = socket;
			connectIO();
		}
		
		private void connectIO() {
			try {
				// 입출력 장치
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	// 읽어들이는 스레드 만들기

	// 읽어들인 메세지 프로토콜 구별하는 메소드 만들기

	@Override
	public void startServer() {
		connectNetwork();

	}

	@Override
	public void sendMessage(String messageText) {

	}

	@Override
	public void connectServer(String ip, int port, String id) {

	}

	private class JoinUser {

	}

	public static void main(String[] args) {
		new Server();
	}
}
