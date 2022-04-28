package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Client implements CallBackClientService, ProtocolImpl {

	// 프레임 창
	private ClientFrame clientFrame;

	private JTextArea mainMessageBox;
	private JList<String> userList;
	private JList<String> roomList;
	private JButton enterRoomBtn;
	private JButton makeRoomBtn;
	private JButton outRoomBtn;
	private JButton secretMsgBtn;
	private JButton sendMessageBtn;

	// 소켓 장치
	private Socket socket;

	// 입출력 장치
	private BufferedReader reader;
	private BufferedWriter writer;

	// 연결 주소
	private String ip;
	private int port;

	// 유저 정보
	private String id;
	private String myRoomName;

	// 토크나이저
	private String protocol;
	private String from;
	private String message;

	// 사용자 이름, 룸이름 벡터 만들기
	private Vector<String> userIdList = new Vector<>();
	private Vector<String> roomNameList = new Vector<>();

	private ImageIcon icon = new ImageIcon("images/erroricon.png");

	public Client() {
		clientFrame = new ClientFrame(this);
		mainMessageBox = clientFrame.getMessagePanel().getMainMessageBox();
		userList = clientFrame.getWaitingRoomPanel().getUserList();
		roomList = clientFrame.getWaitingRoomPanel().getRoomList();
		enterRoomBtn = clientFrame.getWaitingRoomPanel().getEnterRoomBtn();
		makeRoomBtn = clientFrame.getWaitingRoomPanel().getMakeRoomBtn();
		outRoomBtn = clientFrame.getWaitingRoomPanel().getOutRoomBtn();
		secretMsgBtn = clientFrame.getWaitingRoomPanel().getSecretMsgBtn();
		sendMessageBtn = clientFrame.getMessagePanel().getSendMessageBtn();
	}

	@Override
	public void clickConnectServerBtn(String ip, int port, String id) {
		this.ip = ip;
		this.port = port;
		this.id = id;
		try {
			connectNetwork();
			connectIO();

			writer.write(id.trim() + "\n");
			writer.flush();
			clientFrame.setTitle("[ KHA Talk_" + id + "님 ]");

			clientFrame.getIndexPanel().getConnectBtn().setEnabled(false);
			makeRoomBtn.setEnabled(true);
			enterRoomBtn.setEnabled(true);
			secretMsgBtn.setEnabled(true);
			sendMessageBtn.setEnabled(true);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "접속 에러 !", "알림", JOptionPane.ERROR_MESSAGE, icon);
		}
	}

	private void connectNetwork() {
		try {

			// 소켓 장치
			socket = new Socket(ip, port);

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "접속 에러 !", "알림", JOptionPane.ERROR_MESSAGE, icon);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "접속 에러 !", "알림", JOptionPane.ERROR_MESSAGE, icon);
		}
	}

	private void connectIO() {
		try {

			// 입출력 장치
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			readThread();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "클라이언트 입출력 장치 에러 !", "알림", JOptionPane.ERROR_MESSAGE, icon);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "클라이언트 입출력 장치 에러 !", "알림", JOptionPane.ERROR_MESSAGE, icon);
		}
	}

	private void readThread() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						String msg = reader.readLine();

						checkProtocol(msg);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "클라이언트 입력 장치 에러 !", "알림", JOptionPane.ERROR_MESSAGE, icon);
						break;
					}
				}
			}
		}).start();
	}

	private void writer(String str) {
		try {
			writer.write(str + "\n");
			writer.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "클라이언트 출력 장치 에러 !", "알림", JOptionPane.ERROR_MESSAGE, icon);
		}
	}

	private void checkProtocol(String msg) {
		StringTokenizer tokenizer = new StringTokenizer(msg, "/");

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

		} else if (protocol.equals("MadeRoom")) {
			madeRoom();

		} else if (protocol.equals("NewRoom")) {
			newRoom();

		} else if (protocol.equals("OutRoom")) {
			outRoom();

		} else if (protocol.equals("EnterRoom")) {
			enterRoom();

		} else if (protocol.equals("NewUser")) {
			newUser();

		} else if (protocol.equals("ConnectedUser")) {
			connectedUser();
		} else if (protocol.equals("EmptyRoom")) {
			roomNameList.remove(from);
			roomList.setListData(roomNameList);
			makeRoomBtn.setEnabled(true);
			enterRoomBtn.setEnabled(true);
			outRoomBtn.setEnabled(false);
		} else if (protocol.equals("FailMakeRoom")) {
			JOptionPane.showMessageDialog(null, from + "님의 메세지\n\"" + message + "\"", "[비밀메세지]",
					JOptionPane.ERROR_MESSAGE, icon);
		}
	}

	/**
	 * 프로토콜 구별 인터페이스
	 */
	@Override
	public void chatting() {
		if (id.equals(from)) {
			mainMessageBox.append("[나] \n" + message + "\n");
		} else if (from.equals("입장")) {
			mainMessageBox.append("▶" + from + "◀" + message + "\n");
		} else if (from.equals("퇴장")) {
			mainMessageBox.append("▷" + from + "◁" + message + "\n");
		} else {
			mainMessageBox.append("[" + from + "] \n" + message + "\n");
		}
	}

	@Override
	public void secretMessage() {
		JOptionPane.showMessageDialog(null, from + "님의 메세지\n\"" + message + "\"", "[비밀메세지]", JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void makeRoom() {
		myRoomName = from;
		makeRoomBtn.setEnabled(false);
		enterRoomBtn.setEnabled(false);
		outRoomBtn.setEnabled(true);
	}

	@Override
	public void madeRoom() {
		roomNameList.add(from);
		if (!(roomNameList.size() == 0)) {
			roomList.setListData(roomNameList);
		}
	}

	@Override
	public void newRoom() {
		roomNameList.add(from);
		roomList.setListData(roomNameList);
	}

	@Override
	public void outRoom() {
		myRoomName = null;
		mainMessageBox.setText("");
		makeRoomBtn.setEnabled(true);
		enterRoomBtn.setEnabled(true);
		outRoomBtn.setEnabled(false);
	}

	@Override
	public void enterRoom() {
		myRoomName = from;
		makeRoomBtn.setEnabled(false);
		enterRoomBtn.setEnabled(false);
		outRoomBtn.setEnabled(true);
	}

	@Override
	public void newUser() {
		if (!from.equals(this.id)) {
			userIdList.add(from);
			userList.setListData(userIdList);
		}
	}

	@Override
	public void connectedUser() {
		userIdList.add(from);
		userList.setListData(userIdList);
	}

	/**
	 * 클라이언트 화면단에서 정보를 받아오는 콜백 인터페이스<br>
	 * 
	 */
	@Override
	public void clickSendMessageBtn(String messageText) {
		writer("Chatting/" + myRoomName + "/" + messageText);
	}

	@Override
	public void clickSendSecretMessageBtn(String msg) {
		String user = (String) clientFrame.getWaitingRoomPanel().getUserList().getSelectedValue();
		writer("SecretMessage/" + user + "/" + msg);
	}

	@Override
	public void clickMakeRoomBtn(String roomName) {
		writer("MakeRoom/" + roomName);
	}

	@Override
	public void clickOutRoomBtn(String roomName) {
		writer("OutRoom/" + roomName);
	}

	@Override
	public void clickEnterRoomBtn(String roomName) {
		writer("EnterRoom/" + roomName);
	}

	public static void main(String[] args) {
		new Client();
	}
}
