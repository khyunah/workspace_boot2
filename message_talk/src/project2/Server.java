package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

/**
 * 벡터 만들기
 * 
 * @author UserK
 *
 */
public class Server implements CallBackService {

	// 접속된 유저 벡터
	private Vector<ConnectedUser> connectedUsers = new Vector<>();
	// 만들어진 방 벡터
	private Vector<MyRoom> madeMyRoom = new Vector<>();

	// 프레임 창
	private ServerFrame serverFrame;

	// 소켓 장치
	private ServerSocket serverSocket;
	private Socket socket;

	public Server() {
		serverFrame = new ServerFrame(this);
	}

	/**
	 * 포트번호 입력하고 버튼 누르면 포트번호로 서버 시작.
	 */
	@Override
	public void startServer() {
		try {
			// 서버 소켓 장치
			serverSocket = new ServerSocket(10000);
			serverFrame.getMainBoard().append("[알림] 서버 시작\n");

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
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {

						// 소켓 장치
						socket = serverSocket.accept();
						serverFrame.getMainBoard().append("[알림] 사용자 접속 대기\n");

						// 연결을 대기 하다가 유저가 들어오면 유저 생성, 소켓으로 유저 구분 가능.
						ConnectedUser user = new ConnectedUser(socket);
						user.start();
					} catch (IOException e) {
						// 서버 중지
						serverFrame.getMainBoard().append("[알림] 서버 중지 ! !\n");
						break;
					}
				}
			}
		}).start();
	}

	/**
	 * 전체 접속된 유저에게 출력하는 것
	 * 
	 * @param msg
	 */
	private void broadCast(String msg) {
		for (int i = 0; i < connectedUsers.size(); i++) {
			ConnectedUser user = connectedUsers.elementAt(i);
			user.sendMsg(msg);
		}
	}

	private class ConnectedUser extends Thread {
		// 소켓 장치
		private Socket socket;

		// 입출력 장치
		private BufferedReader reader;
		private BufferedWriter writer;

		//
		private String id;
		private String myRoomName;

		public ConnectedUser(Socket socket) {
			this.socket = socket;
			connectIO();
		}

		/**
		 * 유저가 아이디까지 입력하고 연결이 되면, 입출력 장치 소켓 연결.
		 */
		private void connectIO() {
			try {
				// 입출력 장치
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

				sendInfomation();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "입출력 소켓 설정 에러!", "알림", JOptionPane.ERROR_MESSAGE);
			}
		}

		private void sendInfomation() {
			try {
				// 유저의 아이디를 가지고 온다.
				id = reader.readLine();
				serverFrame.getMainBoard().append("[접속]" + id + "님\n");

				// 자기자신을 벡터에 추가
				connectedUsers.add(this);

				// 접속 유저들에게 유저 명단 업데이트를 위한 출력
				broadCast("NewUser/" + id);

				// 방금 연결된 유저측에서 유저 명단 업데이트를 위한 출력
				for (int i = 0; i < connectedUsers.size(); i++) {
					ConnectedUser user = connectedUsers.elementAt(i);
					sendMsg("ConnectedUser/" + user.id);
				}

				// 방금 연결된 유저측에서 룸 명단 업데이트를 위한 출력
				for (int i = 0; i < madeMyRoom.size(); i++) {
					MyRoom myRoom = madeMyRoom.elementAt(i);
					sendMsg("MadeRoom" + myRoom.roomName);
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "접속 에러 !", "알림", JOptionPane.ERROR_MESSAGE);
			}
		}

		@Override
		public void run() {
			while (true) {
				try {
					String msg = reader.readLine();
//					broadCast(msg);
					checkProtocol(msg);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "접속 에러 !", "알림", JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		}

		/**
		 * 프로토콜 별 출력
		 * 
		 * @param msg
		 */
		private void checkProtocol(String msg) {
			StringTokenizer tokenizer = new StringTokenizer(msg, "/");

			String protocol = tokenizer.nextToken();
			String from = tokenizer.nextToken();

			if (protocol.equals("Chatting")) {

				serverFrame.getMainBoard().append("[메세지]" + msg);

				for (int i = 0; i < madeMyRoom.size(); i++) {
					MyRoom myRoom = madeMyRoom.elementAt(i);

					if (myRoom.roomName.equals(from)) {
						myRoom.roomBroadCast(msg);
					}
				}

			} else if (protocol.equals("SecretMsg")) {
				
				serverFrame.getMainBoard().append("[비밀 메세지]" + msg);
				
				for (int i = 0; i < connectedUsers.size(); i++) {
					ConnectedUser user = connectedUsers.elementAt(i);
					
					if(user.id.equals(from)) {
						user.sendMsg(msg);
					}
				}
				
			} else if (protocol.equals("MakeRoom")) {

			} else if (protocol.equals("OutRoom")) {

			}
		}

		private void sendMsg(String msg) {
			try {
				writer.write(msg + "\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private class MyRoom {

		private String roomName;
		private Vector<ConnectedUser> myRoom = new Vector<>();

		public MyRoom(String roomName, ConnectedUser connectedUser) {
			this.roomName = roomName;
			this.myRoom.add(connectedUser);
			connectedUser.myRoomName = roomName;
		}

		/**
		 * 방에 있는 사람들에게 출력
		 */
		private void roomBroadCast(String msg) {
			for (int i = 0; i < myRoom.size(); i++) {
				ConnectedUser user = myRoom.elementAt(i);
				user.sendMsg(msg);
			}
		}

		private void addUser(ConnectedUser connectedUser) {
			myRoom.add(connectedUser);
		}

	}

	@Override
	public void sendMessage(String messageText) {

	}

	@Override
	public void connectServer(String id) {

	}

	public static void main(String[] args) {
		new Server();
	}
}
