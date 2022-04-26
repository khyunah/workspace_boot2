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

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Client implements CallBackService {

	// 프레임 창
	private ClientFrame clientFrame;
	
	private JTextArea mainMessageBox;

	// 소켓 장치
	private Socket socket;

	// 입출력 장치
	private BufferedReader reader;
	private BufferedWriter writer;

	// 연결 주소
	private String ip = "127.0.0.1";
	private int port = 10000;

	// 유저 정보
	private String id;
	private String myRoomName;

	// 사용자 이름, 룸이름 벡터 만들기
	private Vector<String> userIdList = new Vector<>();
	private Vector<String> roomList = new Vector<>();

	public Client() {
		clientFrame = new ClientFrame(this);
		mainMessageBox = clientFrame.getMessagePanel().getMainMessageBox();
	}

	@Override
	public void connectServer(String id) {
		try {
			connectNetwork();
			connectIO();

			userIdList.add("\n" + id);
			clientFrame.getWaitingRoomPanel().getUserList().setListData(userIdList);

			writer.write(id.trim() + "\n");
			writer.flush();

			System.out.println("클라이언트 입력 완료");

		} catch (IOException e) {
			e.printStackTrace();
		}
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

			readThread();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
						e.printStackTrace();
						break;
					}
				}
			}
		}).start();
	}

	private void checkProtocol(String msg) {
		StringTokenizer tokenizer = new StringTokenizer(msg, "/");

		String protocol = tokenizer.nextToken();
		String from = tokenizer.nextToken();

		if (protocol.equals("Chatting")) {
			String message = tokenizer.nextToken();
			mainMessageBox.append("[" + from + " 님이 보낸 메세지] " + message);
		} else if (protocol.equals("SecretMsg")) {
			String message = tokenizer.nextToken();
			JOptionPane.showMessageDialog(null, from + "님의 메세지\n" + message, "[비밀메세지]", JOptionPane.ERROR_MESSAGE);
		} else if (protocol.equals("MakeRoom")) {

		} else if (protocol.equals("OutRoom")) {

		}
	}

	/**
	 * 채팅창에서 메세지를 보냈을때 서버로 출력하는 메소드
	 */
	@Override
	public void sendMessage(String messageText) {
		try {
			writer.write("Chatting/" + myRoomName + "/" + messageText + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendSecretMessage(String msg) {
		String user = (String) clientFrame.getWaitingRoomPanel().getUserList().getSelectedValue();
		try {
			writer.write("SecretMsg/" + user + "/" + msg + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void makeRoom(String roomName) {
		try {
			writer.write("MakeRoom/" + roomName + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void outRoom() {
		try {
			writer.write("OutRoom/" + myRoomName + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}
