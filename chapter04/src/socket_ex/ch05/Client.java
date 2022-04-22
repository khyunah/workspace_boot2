package socket_ex.ch05;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 변수이름 알맞게 고치기, 카멜기법으로 고치기
 * 
 * @author ITPS
 *
 */

public class Client extends JFrame implements ActionListener {

	// GUI자원
	private JPanel mainPanel;
	private JTextField inputHostIP;
	private JTextField inputPortNumber;
	private JTextField inputUserId;
	private JTextField inputMessage;
	private JTextArea mainChatView;
	private JButton connectBtn;
	private JButton sendMessageBtn;
	private JButton sendSecretBtn;
	private JButton joinRoomBtn;
	private JList<String> totalUserList; // 전체접속자 리스트
	private JList<String> totalRoomList; // 방 리스트
	private JButton createRoomBtn;
	private JButton outRoomBtn;
	private JButton exitBtn;
	private JPanel tabPanel;

	// network 자원
	private Socket socket;
	private String ip;
	private int portNumber;
	private String userId;
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;

	// 그외 변수들
	private Vector<String> userIdVector = new Vector<String>();
	private Vector<String> roomListVector = new Vector<String>();
	private StringTokenizer strTokenizer;
	private String myRoomName;

	public Client() {
		init();
		addListener();
	}

	private void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 483);

		// 메인 패널
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(null);
		setContentPane(mainPanel);

		// tabPane
		// 지정된 제목 및/또는 아이콘이 있는 탭을 클릭하여 구성요소 그룹 간에 전환할 수 있는 구성요소
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setBounds(12, 27, 328, 407);
		mainPanel.add(tabPane);

		// 탭 1. 로그인
		tabPanel = new JPanel();
		tabPanel.setLayout(null);
		tabPane.addTab("로그인", null, tabPanel, null);

		JLabel hostIPLabel = new JLabel("Host_IP ");
		hostIPLabel.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		hostIPLabel.setBounds(12, 25, 91, 15);
		tabPanel.add(hostIPLabel);

		inputHostIP = new JTextField();
		inputHostIP.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		inputHostIP.setBounds(112, 21, 199, 21);
		inputHostIP.setColumns(10);
		inputHostIP.setText("127.0.0.1");
		tabPanel.add(inputHostIP);

		JLabel serverPortLabel = new JLabel("Server_Port");
		serverPortLabel.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		serverPortLabel.setBounds(12, 72, 91, 15);
		tabPanel.add(serverPortLabel);

		inputPortNumber = new JTextField();
		inputPortNumber.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		inputPortNumber.setBounds(112, 69, 199, 21);
		inputPortNumber.setColumns(10);
		tabPanel.add(inputPortNumber);

		JLabel userIdLabel = new JLabel("User_ID");
		userIdLabel.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		userIdLabel.setBounds(12, 122, 91, 15);
		tabPanel.add(userIdLabel);

		inputUserId = new JTextField();
		inputUserId.setBounds(112, 119, 199, 21);
		inputUserId.setColumns(10);
		tabPanel.add(inputUserId);

		// 존재 이유?
		JLabel img_lbl = new JLabel("input the image");
		img_lbl.setIcon(new ImageIcon());
		img_lbl.setBounds(12, 213, 299, 155);
		tabPanel.add(img_lbl);

		connectBtn = new JButton("connect");
		connectBtn.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		connectBtn.setBounds(214, 162, 97, 23);
		tabPanel.add(connectBtn);

		// 탭 2. 대기실
		JPanel waitingPanel = new JPanel();
		tabPane.addTab("대기실", null, waitingPanel, null);
		waitingPanel.setLayout(null);

		JLabel totalUserListLabel = new JLabel("전체접속자");
		totalUserListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalUserListLabel.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		totalUserListLabel.setBounds(12, 28, 102, 15);
		waitingPanel.add(totalUserListLabel);

		JLabel totalRoomListLabel = new JLabel("방 리스트");
		totalRoomListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalRoomListLabel.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		totalRoomListLabel.setBounds(209, 27, 102, 15);
		waitingPanel.add(totalRoomListLabel);

		totalUserList = new JList<>();
		totalUserList.setBounds(12, 69, 102, 257);
		waitingPanel.add(totalUserList);

		totalRoomList = new JList<>();
		totalRoomList.setBounds(209, 69, 102, 257);
		waitingPanel.add(totalRoomList);

		sendSecretBtn = new JButton("쪽지보내기");
		sendSecretBtn.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		sendSecretBtn.setBounds(12, 345, 102, 23);
		waitingPanel.add(sendSecretBtn);

		joinRoomBtn = new JButton("채팅방참여");
		joinRoomBtn.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		joinRoomBtn.setBounds(209, 345, 102, 23);
		waitingPanel.add(joinRoomBtn);

		// 탭 3. 채팅
		JPanel chattingPanel = new JPanel();
		tabPane.addTab("채팅", null, chattingPanel, null);
		chattingPanel.setLayout(null);

		mainChatView = new JTextArea();
		mainChatView.setEnabled(false);
		mainChatView.setEditable(false);
		mainChatView.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		mainChatView.setBounds(0, 0, 323, 337);
		chattingPanel.add(mainChatView);

		inputMessage = new JTextField();
		inputMessage.setFont(new Font("휴먼모음T", Font.BOLD, 11));
		inputMessage.setBounds(0, 347, 214, 21);
		inputMessage.setColumns(10);
		chattingPanel.add(inputMessage);

		sendMessageBtn = new JButton("전 송");
		sendMessageBtn.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		sendMessageBtn.setBounds(226, 346, 97, 23);
		chattingPanel.add(sendMessageBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(0, 0, 323, 337);
		chattingPanel.add(scrollPane);

		createRoomBtn = new JButton("방 만들기");
		createRoomBtn.setFont(new Font("휴먼모음T", Font.BOLD, 11));
		createRoomBtn.setBounds(352, 93, 97, 23);
		mainPanel.add(createRoomBtn);

		outRoomBtn = new JButton("방 나가기");
		outRoomBtn.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		outRoomBtn.setBounds(352, 150, 97, 23);
		mainPanel.add(outRoomBtn);
		outRoomBtn.setEnabled(false);
		exitBtn = new JButton("종료");
		exitBtn.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		exitBtn.setBounds(352, 398, 97, 23);
		mainPanel.add(exitBtn);

		setVisible(true);
	}

	private void connectServer() {
		try {
			// 서버에 접속합니다.
			socket = new Socket(ip, portNumber);
			network();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void network() {

		try {
			// 서버측에서 읽어올 소켓 연결
			is = socket.getInputStream();
			dis = new DataInputStream(is);

			// 서버측으로 보낼 소켓 연결
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);

			userId = inputUserId.getText().trim();
			sendmessage(userId);

			// 벡터에 유저의 id 를 저장하고 리스트 화면에 추가시켜준다.
			userIdVector.add(userId);
			totalUserList.setListData(userIdVector);

			// 멀티 스레드로 서버에서 출력하는 것을 읽어들이는 중
			Thread th = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							String msg = dis.readUTF(); // 유니코드 UTF-8형식으로 읽어주고 UTF-8의 String으로 반환한다.
							inmessage(msg);
						} catch (IOException e) {
							try {
								userIdVector.removeAll(userIdVector);
								roomListVector.removeAll(roomListVector);
								totalUserList.setListData(userIdVector);
								totalRoomList.setListData(roomListVector);
								mainChatView.setText("\n");
								is.close();
								os.close();
								dis.close();
								dos.close();
								socket.close();
								JOptionPane.showMessageDialog(null, "서버가 종료됨!", "알림", JOptionPane.ERROR_MESSAGE);
								break;
							} catch (Exception e2) {
								return;
							}
						}
					}
				}
			});
			th.start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		} // Stream 준비완료
		connectBtn.setEnabled(false);
	}

	// 서버로부터 읽어온 문자열 처리
	private void inmessage(String str) {

		strTokenizer = new StringTokenizer(str, "/");

		String protocol = strTokenizer.nextToken();
		String from = strTokenizer.nextToken();

		System.out.println("프로토콜" + protocol);
		System.out.println("메세지" + from);

		/**
		 * 프로토콜 NewUser<br>
		 * 전체 접속자 명단에 추가해줌.
		 */
		if (protocol.equals("NewUser")) {
			userIdVector.add(from);
			totalUserList.setListData(userIdVector);

			/**
			 * 프로토콜 OldUser<br>
			 * 전체 접속자 명단에 추가해줌.
			 */
		} else if (protocol.equals("OldUser")) {
			userIdVector.add(from);
			totalUserList.setListData(userIdVector);

			/**
			 * 프로토콜 secretMsg<br>
			 * 쪽지보내기 기능의 프로토콜<br>
			 * 보낸이@작성한 메세지 구조
			 */
		} else if (protocol.equals("secretMsg")) {
			strTokenizer = new StringTokenizer(from, "@");
			String user = strTokenizer.nextToken();
			String secretMsg = strTokenizer.nextToken();
			JOptionPane.showMessageDialog(null, secretMsg, user + "로 부터 온 메세지", JOptionPane.CLOSED_OPTION);

			/**
			 * 프로토콜 CreateRoom<br>
			 */
		} else if (protocol.equals("CreateRoom")) {
			myRoomName = from;
			joinRoomBtn.setEnabled(false);
			outRoomBtn.setEnabled(true);
			createRoomBtn.setEnabled(false);

			/**
			 * 프로토콜 CreateRoomFail<br>
			 */
		} else if (protocol.equals("CreateRoomFail")) {
			JOptionPane.showMessageDialog(null, "같은 방 이름이 존재합니다.!", "알림", JOptionPane.ERROR_MESSAGE);

			/**
			 * 프로토콜 new_Room<br>
			 * 생성한 룸을 방 리스트 명단에 올린다.
			 */
		} else if (protocol.equals("new_Room")) {
			roomListVector.add(from);
			totalRoomList.setListData(roomListVector);

			/**
			 * 프로토콜 Chatting<br>
			 * 채팅창에 받은 메시지를 띄어준다.
			 */
		} else if (protocol.equals("Chatting")) {
			String msg = strTokenizer.nextToken();
			mainChatView.append(from + " : " + msg + "\n");

			/**
			 * 프로토콜 OldRoom<br>
			 * 방 리스트 명단에 기존 룸 추가
			 */
		} else if (protocol.equals("OldRoom")) {
			roomListVector.add(from);
			totalRoomList.setListData(roomListVector);

			/**
			 * 프로토콜 JoinRoom
			 * 
			 */
		} else if (protocol.equals("JoinRoom")) {
			myRoomName = from;
			JOptionPane.showMessageDialog(null, "채팅방 (  " + myRoomName + " ) 에 입장완료", "알림",
					JOptionPane.INFORMATION_MESSAGE);
			mainChatView.setText("");
		} else if (protocol.equals("UserOut")) {
			userIdVector.remove(from);
			sendmessage("OutRoom/" + myRoomName);
		} else if (protocol.equals("UserData_Updata")) {
			totalUserList.setListData(userIdVector);
			totalRoomList.setListData(roomListVector);
		} else if (protocol.equals("OutRoom")) {
			mainChatView.append("*** (( " + myRoomName + "에서 퇴장 ))***\n");
			myRoomName = null;
			createRoomBtn.setEnabled(true);
			outRoomBtn.setEnabled(false);
		} else if (protocol.equals("EmptyRoom")) {
			roomListVector.remove(from);
			// 클라이언트가 강제 종료 되었고 방이 비었을때 방 목록에서 그 방을 없애준다.
		} else if (protocol.equals("ErrorOutRoom")) {
			roomListVector.remove(from);
		}
	}

	private void sendmessage(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 이벤트리스너
	private void addListener() {
		connectBtn.addActionListener(this);
		sendMessageBtn.addActionListener(this);
		sendSecretBtn.addActionListener(this);
		joinRoomBtn.addActionListener(this);
		inputMessage.addActionListener(this);
		exitBtn.addActionListener(this);
		createRoomBtn.addActionListener(this);
		outRoomBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connectBtn) {
			if (inputHostIP.getText().length() == 0) {
				inputHostIP.setText("IP를 입력하세요");
				inputHostIP.requestFocus();
			} else if (inputPortNumber.getText().length() == 0) {
				inputPortNumber.setText("포트번호를 입력하세요");
				inputPortNumber.requestFocus();
			} else if (inputUserId.getText().length() == 0) {
				inputUserId.setText("id 를 입력하세요");
				inputUserId.requestFocus();
			} else {
				ip = inputHostIP.getText();
				try {
					portNumber = Integer.parseInt(inputPortNumber.getText().trim());
				} catch (Exception e2) {
					inputPortNumber.setText("잘못 입력하였습니다.");
				}
				userId = inputUserId.getText().trim();
				// 서버연결하기
				connectServer();
				setTitle("[" + userId + " ] 님 깨알톡에 오신걸 환영합니다.");
			}
		} else if (e.getSource() == sendMessageBtn) {
			System.out.println("전송버튼클릭");
			sendmessage("Chatting/" + myRoomName + "/" + inputMessage.getText().trim());
		} else if (e.getSource() == sendSecretBtn) {
			System.out.println("쪽지보내기버튼 클릭");
			String user = (String) totalUserList.getSelectedValue();
			if (user == null) {
				JOptionPane.showMessageDialog(null, "대상을 선택하세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
			String note = JOptionPane.showInputDialog("보낼메세지");
			if (note != null) {
				sendmessage("Note/" + user + "@" + note);
			}
		} else if (e.getSource() == joinRoomBtn) {
			System.out.println("방입장버튼 클릭");
			String joinRoom = (String) totalRoomList.getSelectedValue();
			outRoomBtn.setEnabled(true);
			createRoomBtn.setEnabled(false);
			sendmessage("JoinRoom/" + joinRoom);
		} else if (e.getSource() == inputMessage) {
			if (inputMessage.getText().length() == 0) {
				System.out.println("이게 0값으로 들어가나?");
				sendmessage("Chatting/" + myRoomName + "/" + inputMessage.getText() + "   ");
			} else {
				sendmessage("Chatting/" + myRoomName + "/" + inputMessage.getText());
			}
		} else if (e.getSource() == createRoomBtn) {
			System.out.println("방생성버튼클릭");
			String roomName = JOptionPane.showInputDialog("방 이름을 입력하세요");
			if (roomName != null) {
				sendmessage("CreateRoom/" + roomName);
			}
		} else if (e.getSource() == outRoomBtn) {
			System.out.println("방나가기버튼클릭.");
			sendmessage("OutRoom/" + myRoomName);
		} else if (e.getSource() == exitBtn) {
			System.exit(0);
		}
		inputMessage.setText("");
	}

	public static void main(String[] args) {
		new Client();
	}
}
