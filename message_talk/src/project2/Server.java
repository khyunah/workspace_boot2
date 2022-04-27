package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 벡터 만들기
 * 
 * @author UserK
 *
 */
public class Server {

	// 접속된 유저 벡터
	private Vector<ConnectedUser> connectedUsers = new Vector<>();
	// 만들어진 방 벡터
	private Vector<MyRoom> madeRooms = new Vector<>();

	// 프레임 창
	private ServerFrame serverFrame;

	private JTextArea mainBoard;

	// 소켓 장치
	private ServerSocket serverSocket;
	private Socket socket;

	// 방 만들기 같은 방 이름 체크
	private boolean roomCheck;

	private String protocol;
	private String from;
	private String message;

	public Server() {
		serverFrame = new ServerFrame(this);
		roomCheck = true;
		mainBoard = serverFrame.getMainBoard();
	}

	/**
	 * 포트번호 입력하고 버튼 누르면 포트번호로 서버 시작.
	 */
	public void startServer() {
		try {
			// 서버 소켓 장치
			serverSocket = new ServerSocket(10000);
			serverFrame.getMainBoard().append("[알림] 서버 시작\n");
			serverFrame.getConnectBtn().setEnabled(false);
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
						mainBoard.append("[알림] 사용자 접속 대기\n");

						// 연결을 대기 하다가 유저가 들어오면 유저 생성, 소켓으로 유저 구분 가능.
						ConnectedUser user = new ConnectedUser(socket);
						user.start();
					} catch (IOException e) {
						// 서버 중지
						serverFrame.getMainBoard().append("[에러] 서버 중지 ! !\n");
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
			user.writer(msg);
		}
	}

	private class ConnectedUser extends Thread implements ProtocolImpl {
		// 소켓 장치
		private Socket socket;

		// 입출력 장치
		private BufferedReader reader;
		private BufferedWriter writer;

		// 파일 저장을 위한 장치
		private FileWriter fileWriter;

		//
		private String id;
		private String myRoomName;

		public ConnectedUser(Socket socket) {
			this.socket = socket;
			connectIO();
		}

		private void fileWriter(String str) {
			try {
				fileWriter = new FileWriter("kha_talk_log.txt", true);

				fileWriter.write(str + "\n");
				fileWriter.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
				serverFrame.getMainBoard().append("[에러] 입출력 소켓 설정 에러 ! !\n");
			}
		}

		private void sendInfomation() {
			try {
				// 유저의 아이디를 가지고 온다.
				id = reader.readLine();
				mainBoard.append("[접속] " + id + "님\n");

				// 접속된 유저들에게 유저 명단 업데이트를 위한 출력
				newUser();

				// 방금 연결된 유저측에서 유저 명단 업데이트를 위한 출력
				connectedUser();

				// 방금 연결된 유저측에서 룸 명단 업데이트를 위한 출력
				madeRoom();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "접속 에러 !", "알림", JOptionPane.ERROR_MESSAGE);
				serverFrame.getMainBoard().append("[에러] 접속 에러 ! !\n");
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					String str = reader.readLine();
					checkProtocol(str);
					fileWriter(str);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "접속 에러 !", "알림", JOptionPane.ERROR_MESSAGE);
				serverFrame.getMainBoard().append("[에러] 접속 에러 ! !\n");
			}
		}

		/**
		 * 프로토콜 별 출력
		 * 
		 * @param str
		 */
		private void checkProtocol(String str) {
			StringTokenizer tokenizer = new StringTokenizer(str, "/");

			protocol = tokenizer.nextToken();
			from = tokenizer.nextToken();

			if (protocol.equals("Chatting")) {
				message = tokenizer.nextToken();
				chatting();

			} else if (protocol.equals("SecretMessage")) {
				message = tokenizer.nextToken();
				secretMessage();

			} else if (protocol.equals("MakeRoom")) {
				makeRoom();

			} else if (protocol.equals("OutRoom")) {
				outRoom();

			} else if (protocol.equals("EnterRoom")) {
				enterRoom();
			}
		}

		private void writer(String str) {
			try {
				writer.write(str + "\n");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void chatting() {
			mainBoard.append("[메세지] " + from + "_" + message + "\n");

			for (int i = 0; i < madeRooms.size(); i++) {
				MyRoom myRoom = madeRooms.elementAt(i);

				if (myRoom.roomName.equals(from)) {
					myRoom.roomBroadCast("Chatting/" + id + "/" + message);
				}
			}
		}

		@Override
		public void secretMessage() {
			mainBoard.append("[비밀 메세지] " + id + "ㅡ>" + from + "_" + message + "\n");

			for (int i = 0; i < connectedUsers.size(); i++) {
				ConnectedUser user = connectedUsers.elementAt(i);

				if (user.id.equals(from)) {
					user.writer("SecretMessage/" + id + "/" + message);
				}
			}
		}

		@Override
		public void makeRoom() {
			for (int i = 0; i < madeRooms.size(); i++) {
				MyRoom room = madeRooms.elementAt(i);

				if (room.roomName.equals(from)) {
					writer("Fail/MakeRoom");
					mainBoard.append("[방 생성 실패]" + id + "_" + from + "\n");
					roomCheck = false;
				} else {
					roomCheck = true;
				}
			}

			if (roomCheck) {
				MyRoom myRoom = new MyRoom(from, this);
				madeRooms.add(myRoom);
				mainBoard.append("[방 생성]" + id + "_" + from + "\n");
				System.out.println("방을 생성하였습니다");

				newRoom();
				writer("MakeRoom/" + from);
			}
		}

		@Override
		public void newRoom() {
			broadCast("NewRoom/" + from);
		}

		@Override
		public void outRoom() {
			for (int i = 0; i < madeRooms.size(); i++) {
				MyRoom myRoom = madeRooms.elementAt(i);

				if (myRoom.roomName.equals(from)) {
					myRoom.removeRoom(this);
					mainBoard.append("[방 삭제]" + id + "_" + from + "\n");
					writer("OutRoom/" + from + "\n");
				}
			}
		}

		@Override
		public void enterRoom() {
			for (int i = 0; i < madeRooms.size(); i++) {
				MyRoom myRoom = madeRooms.elementAt(i);

				if (myRoom.roomName.equals(from)) {
					myRoom.addUser(this);
					myRoom.roomBroadCast("Chatting/알림/" + id + "님 입장");
					serverFrame.getMainBoard().append("[입장]" + from + " 방_" + id + "\n");
					writer("EnterRoom/" + from);
				}
			}
		}

		@Override
		public void newUser() {
			// 자기자신을 벡터에 추가
			connectedUsers.add(this);
			broadCast("NewUser/" + id);
		}

		@Override
		public void connectedUser() {
			for (int i = 0; i < connectedUsers.size(); i++) {
				ConnectedUser user = connectedUsers.elementAt(i);
				writer("ConnectedUser/" + user.id);
			}
		}
		
		@Override
		public void madeRoom() {
			for (int i = 0; i < madeRooms.size(); i++) {
				MyRoom myRoom = madeRooms.elementAt(i);
				writer("MadeRoom/" + myRoom.roomName);
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

		@Override
		public String toString() {
			return roomName;
		}

		/**
		 * 방에 있는 사람들에게 출력
		 */
		private void roomBroadCast(String msg) {
			for (int i = 0; i < myRoom.size(); i++) {
				ConnectedUser user = myRoom.elementAt(i);

				user.writer(msg);
			}
		}

		private void addUser(ConnectedUser connectedUser) {
			myRoom.add(connectedUser);
			System.out.println("방에 유저 추가됨");
		}

		private void removeRoom(ConnectedUser user) {
			myRoom.remove(user);
			boolean empty = myRoom.isEmpty();
			if (empty) {
				for (int i = 0; i < madeRooms.size(); i++) {
					MyRoom myRoom = madeRooms.elementAt(i);

					if (myRoom.roomName.equals(roomName)) {
						madeRooms.remove(this);
						broadCast("EmptyRoom/" + roomName);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}
