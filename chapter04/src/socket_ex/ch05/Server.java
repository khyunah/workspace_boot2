package socket_ex.ch05;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame implements ActionListener {

	// GUI 자원
	private JPanel mainPanel; // 전체적인 틀
	private ScrollPane scrollPane;
	private JTextField inputPortNumber; // 포트번호 입력
	private JTextArea mainTextarea; // 실행흐름을 띄우는 곳
	private JLabel portNumLabel; // 포트번호 라벨
	private JButton serverStartBtn;
	private JButton serverStopBtn;

	// Network 자원
	private ServerSocket serverSocket; // 서버에 연결을 시켜주기 위한 서버 소켓
	private Socket socket; // 소통을 위한 소켓
	private int portNumber; // inputPortNumber 에 입력 받은 값은 String이라 형변환후 저장 공간

	// 모든 유저 정보
	private Vector<UserInfomation> allUserInfoVector = new Vector<UserInfomation>();
	// 모든 방 정보
	private Vector<RoomInfomation> allRoomInfoVector = new Vector<RoomInfomation>();

	public Server() {
		init();
		addListener();
		inputPortNumber.requestFocus(); // 처음 시작 할때 포커스 JTextField tfPort로 요청
	}

	// GUI 초기화
	private void init() {

		// 전체 패널
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // EmptyBorder 공간은 차지하지만 빈 투명 테두리
		mainPanel.setLayout(null);
		setBounds(100, 100, 350, 410);
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// mainTextarea
		scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 10, 309, 229);
		mainPanel.add(scrollPane);
		mainTextarea = new JTextArea();
		mainTextarea.setBounds(12, 11, 310, 230);
		mainTextarea.setEditable(false); // setEditable(false) ㅡ> 텍스트 필드에 입력을 못하게 한다
		scrollPane.add(mainTextarea);

		// portNumLabel
		portNumLabel = new JLabel("포트번호 :");
		portNumLabel.setBounds(12, 273, 82, 15);
		mainPanel.add(portNumLabel);

		// inputPortNumber
		inputPortNumber = new JTextField();
		inputPortNumber.setBounds(98, 270, 224, 21);
		mainPanel.add(inputPortNumber);
		inputPortNumber.setColumns(10);

		// 서버 실행 버튼
		serverStartBtn = new JButton("서버실행");
		serverStartBtn.setBounds(12, 315, 154, 23);
		mainPanel.add(serverStartBtn);

		// 서버 중지 버튼
		serverStopBtn = new JButton("서버중지");
		serverStopBtn.setBounds(168, 315, 154, 23);
		serverStopBtn.setEnabled(false); // 비활성화 setEnabled(false)
		mainPanel.add(serverStopBtn);

		setVisible(true);
	}

	// 이벤트 리스너
	private void addListener() {
		serverStartBtn.addActionListener(this);
		serverStopBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 서버 시작 버튼
		if (e.getSource() == serverStartBtn) {

			// 입력한 값이 없다면 값 입력을 알려줌.
			if (inputPortNumber.getText().length() == 0) {
				System.out.println("  값을 입력 하세요 ");

				// 입력한 값이 있다면
			} else if (inputPortNumber.getText().length() != 0) {

				// 입력한 값이 String 타입이기 때문에 가져와서 형변환 후 int port변수에 저장
				portNumber = Integer.parseInt(inputPortNumber.getText());
				startNetwork();

				// 연결이 되고 나면 포트번호 입력, 서버 시작 버튼, 서버 중지 버튼 비활성화.
				inputPortNumber.setEditable(false);
				serverStartBtn.setEnabled(false);
				serverStopBtn.setEnabled(true);
			}

		} else if (e.getSource() == serverStopBtn) {
			try {
				serverSocket.close();
				allUserInfoVector.removeAllElements();
				allRoomInfoVector.removeAllElements();
				inputPortNumber.setEditable(true);
				serverStartBtn.setEnabled(true);
				serverStopBtn.setEnabled(false);
			} catch (IOException e1) {

			}
		}
	}

	/**
	 * 입력받은 포트넘버로 서버소켓을 생성한다.
	 */
	private void startNetwork() {
		try {
			// 1. 연결을 받아줄 서버소켓 생성
			serverSocket = new ServerSocket(portNumber);
			mainTextarea.append("서버를 시작 하겠습니다.\n");
			connect();

			// 입출력 오류가 났을때
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "알림", JOptionPane.ERROR_MESSAGE);
			serverStartBtn.setEnabled(true);
			serverStopBtn.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못입력하였습니다.", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void connect() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						mainTextarea.append("사용자의 접속을 기다립니다.\n");

						// 다른 서버 연결을 위해 무한 대기
						socket = serverSocket.accept();

						UserInfomation useInfo = new UserInfomation(socket);
						// 각각의 스레드를 등록시켜준다.
						useInfo.start();
					} catch (IOException e) {
						mainTextarea.append("서버가 중지됨! 다시 스타트 버튼을 눌러주세요\n");
						break;
					}
				}
			}
		});
		th.start();
	}

	// 전체 사용자에게 메세지를 출력하는 부분
	public void broadCast(String str) {
		for (int i = 0; i < allUserInfoVector.size(); i++) {
			UserInfomation userInfo = allUserInfoVector.elementAt(i);
			// 여기서 프로토콜의 개념을 사용
			userInfo.sendmessage(str);
		}
	}

	// 내부클래스
	class UserInfomation extends Thread {
		private InputStream is;
		private OutputStream os;

		/**
		 * 데이터 출력 스트림은 응용 프로그램이 휴대용 방식으로 출력 스트림에 원시 자바 데이터 유형을 쓸 수 있게 한다. 그런 다음 응용 프로그램은
		 * 데이터 입력 스트림을 사용하여 데이터를 다시 읽을 수 있습니다. DataOutputStream은 여러 개의 동시 스레드에서 사용할 수
		 * 없습니다. 데이터 출력 스트림을 두 개 이상의 스레드에서 사용하려면 데이터 출력 스트림에 대한 액세스를 적절한 동기화에 의해 제어해야
		 * 합니다.
		 */
		private DataInputStream dis;
		private DataOutputStream dos;
		private String nickName;
		private String myCurrentRoomName;
		private Socket userSocket;

		private boolean roomCheck = true;

		// 유저가 생성되면 네트워크를 연결
		public UserInfomation(Socket socket) {
			this.userSocket = socket;
			network();
		}

		/**
		 * 소켓을 생성하고 스트림 연결.
		 */
		private void network() {
			try {
				// 클라이언트에서 읽어올 스트림
				is = userSocket.getInputStream();
				dis = new DataInputStream(is);

				// 클라이언트로 보낼 스트림
				os = userSocket.getOutputStream();
				dos = new DataOutputStream(os);

				// 1. 유저의 id를 읽어온다.
				nickName = dis.readUTF(); // 유니코드 스트링으로 리턴 해준다.
				mainTextarea.append("[[" + nickName + "]] 입장\n");

				// 2. 기존사용자들에게 신규 유저의 접속을 알린다.
				broadCast("NewUser/" + nickName);

				// 3. allUserInfoVector에 자신(UserInfomation)을 추가한다.
				allUserInfoVector.add(this);

				// 4. allUserInfoVector에 담긴 유저들의 닉네임을 보낸다.
				for (int i = 0; i < allUserInfoVector.size(); i++) {
					// elementAt 인덱스의 값을 가지고 온다.
					UserInfomation uinf = allUserInfoVector.elementAt(i);
					sendmessage("OldUser/" + uinf.nickName);
				}

				// 5. allRoomInfoVector에 담긴 룸의 이름을 보낸다.
				for (int i = 0; i < allRoomInfoVector.size(); i++) {
					RoomInfomation room = allRoomInfoVector.elementAt(i);
					sendmessage("OldRoom/" + room.roomName);
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream설정에러!", "알림", JOptionPane.ERROR_MESSAGE);
			}
		}

		// 브로드캐스트
		// 클라이언트측에서 보낸 메세지를 읽어오는 스레드
		@Override
		public void run() {
			while (true) {
				try {
					// 클라이언트에게서 읽어온다.
					String msg = dis.readUTF();
					mainTextarea.append("[[" + nickName + "]]" + msg + "\n");

					protocolCheckMessage(msg);

					// 입출력에 오류가 생겼을 때
				} catch (IOException e) {
					try {
						mainTextarea.append(nickName + " : 사용자접속끊어짐\n");
						dos.close();
						dis.close();
						userSocket.close();
						allUserInfoVector.remove(this);
						allRoomInfoVector.remove(this);
						broadCast("UserOut/" + nickName);
						broadCast("ErrorOutRoom/" + myCurrentRoomName);
						broadCast("UserData_Updata/ok");
						break;
					} catch (IOException e1) {
						break;
					}
				}
			}
		}

		/**
		 * 프로토콜 확인해서 해당 프로토콜 별 입 출력<br>
		 * 
		 * @param str
		 */
		private void protocolCheckMessage(String str) {
			System.out.println();
			StringTokenizer st = new StringTokenizer(str, "/");

			String protocol = st.nextToken();
			String from = st.nextToken();

			System.out.println("protocol : " + protocol);
			System.out.println("from : " + from);

			// 프로토콜 secretMsg
			if (protocol.equals("secretMsg")) {
				// @를 기준으로 문자열을 분할한
				st = new StringTokenizer(from, "@");
				String user = st.nextToken();
				String secretMsg = st.nextToken();
				
				// 백터에서 해당 사용자를 찾아서 쪽지를 전송한다.
				for (int i = 0; i < allUserInfoVector.size(); i++) {
					UserInfomation u = allUserInfoVector.elementAt(i);
					
					// 쪽지는 반드시 찾은 사용자에게 메세지를 보내줘어야 한다.
					if (u.nickName.equals(user)) {
						u.sendmessage("secretMsg/" + nickName + "@" + secretMsg);
					}
				}
				
				// 프로토콜 CreateRoom
			} else if (protocol.equals("CreateRoom")) {
				
				// 1. 현재 같은 이름의 방이 존재하는지 확인한다.
				for (int i = 0; i < allRoomInfoVector.size(); i++) {
					RoomInfomation room = allRoomInfoVector.elementAt(i);
					
					// 만들고자 하는 방 이름을 확인한다
					if (room.roomName.equals(from)) { 
						sendmessage("CreateRoomFail/ok");
						roomCheck = false;
						break;
					} else {
						roomCheck = true;
					}
				} // end for
				
				// 2. 방이 존재 하지 않으면 roomCheck == true
				if (roomCheck) {
					
					// 방을 생성한다.
					RoomInfomation createRoom = new RoomInfomation(from, this);
					
					// 전체 방 벡터에 생성된 방을 저장한다.
					allRoomInfoVector.add(createRoom);
					
					// 방이 생성되었다고 알려준다.
					sendmessage("CreateRoom/" + from); // 자신에게 방 성공 메세지를 보낸다.
					broadCast("new_Room/" + from); // 클라이언트들에게 보낼 메세지
				}
				
				// 프로토콜 Chatting
			} else if (protocol.equals("Chatting")) {
				String msg = st.nextToken();
				for (int i = 0; i < allRoomInfoVector.size(); i++) {
					RoomInfomation r = allRoomInfoVector.elementAt(i);
					if (r.roomName.equals(from)) {
						r.roomBroadcast("Chatting/" + nickName + "/" + msg);
					}
				}
				
				// 프로토콜 JoinRoom
			} else if (protocol.equals("JoinRoom")) {
				for (int i = 0; i < allRoomInfoVector.size(); i++) {
					RoomInfomation r = allRoomInfoVector.elementAt(i);
					if (r.roomName.equals(from)) {
						// 신규접속자를 알린다.
						r.roomBroadcast("Chatting/[[알림]]/(((" + nickName + " 입장))) ");
						r.addUser(this); // 해당 룸 객체에 자신을 추가시킨다.
						sendmessage("JoinRoom/" + from);
					}
				}
				
				// 프로토콜 OutRoom
			} else if (protocol.equals("OutRoom")) {
				for (int i = 0; i < allRoomInfoVector.size(); i++) {
					RoomInfomation r = allRoomInfoVector.elementAt(i);
					if (r.roomName.equals(from)) {
						r.removeRoom(this);
						sendmessage("OutRoom/ok");
						break;
					}
				}
			}
		}

		// 아웃 메세지 ( 클라이언트에게 보내는 역할 )
		private void sendmessage(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 내부클래스
	// 만들어진 방에 대한 정보
	class RoomInfomation {

		String roomName;
		Vector<UserInfomation> createUserVector = new Vector<UserInfomation>();

		public RoomInfomation(String roomName, UserInfomation u) {
			this.roomName = roomName;
			this.createUserVector.add(u);
			u.myCurrentRoomName = roomName;
		}

		// 방에 있는 사람에게 메세지 보내는 기능
		private void roomBroadcast(String str) { // 현재방의 모든 사람들에게 알린다.
			for (int i = 0; i < createUserVector.size(); i++) {
				UserInfomation u = createUserVector.elementAt(i);
				u.sendmessage(str);
			}
		}

		// 방에 사람을 추가하는 기능
		private void addUser(UserInfomation u) {
			createUserVector.add(u);
		}

		@Override
		public String toString() {
			return roomName;
		}

		// 방에 사람이 아무도 없으면 방을 지우기
		private void removeRoom(UserInfomation u) {
			createUserVector.remove(u);
			boolean empty = createUserVector.isEmpty();
			if (empty) {
				for (int i = 0; i < allRoomInfoVector.size(); i++) {
					RoomInfomation r = allRoomInfoVector.elementAt(i);
					if (r.roomName.equals(roomName)) {
						allRoomInfoVector.remove(this);
						broadCast("EmptyRoom/" + roomName);
						broadCast("UserData_Updata/ok");
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
