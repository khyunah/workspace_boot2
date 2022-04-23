package socket_ex.ch04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile implements CallBackSaveBtn {

	ServerSocket serverSocket;
	Socket socket;

	BufferedReader bufferedReader;

	//////////////////////////////////////////////////////////

	BufferedWriter bufferedWriter; // 클라이언트 쪽으로 데이터를 보내는 녀석
	BufferedReader keyboardBufferedReader; // 입력 받을 녀석
	
	//////////////////////////////////////////////////////////
	
	MessageFrame frame;
	String pushMessage;

	public ServerFile() {
		
		frame = new MessageFrame(this);
		try {
			System.out.println("1. >>>>> 서버 소켓 시작 <<<<<");
			serverSocket = new ServerSocket(10000);
			System.out.println("2. 서버 소켓 생성 완료");

			// 요청을 계속 대기하는 중
			socket = serverSocket.accept();
			System.out.println("3. 클라이언트 연결 완료");

			// 클라이언트 측의 요청을 소켓으로 받는 준비
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 초기화 처리
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			// 클라이언트에게 보낼 아웃풋 스트림 연결
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 스레드 처리
			WriteThread writeThread = new WriteThread();
			Thread thread = new Thread(writeThread);
			thread.start();

			while (true) {
				String msg = bufferedReader.readLine();
				frame.pullMessage.setText(frame.pullMessage.getText() + "클라이언트가 보낸 메세지 : " + msg + "\n");
				System.out.println("클라이언트로 받은 메세지 : " + msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("예외발생");
		} finally {
			// 역순으로 닫아줘야 함
			try {
				bufferedReader.close();
				keyboardBufferedReader.close();
				bufferedWriter.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	// 내부 클래스
	private class WriteThread implements Runnable {

		@Override
		public void run() {

			while (true) {

				try {
					// 키보드에서 데이터를 읽어줌
					String msg = keyboardBufferedReader.readLine();

					// 클라이언트로 데이터 보내기 ㅡ> 소켓 연결
					bufferedWriter.write(msg);
					bufferedWriter.write("\n");
					bufferedWriter.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void saveFile(String msg) {
		this.pushMessage = msg;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					bufferedWriter.write(msg + "\n");
					bufferedWriter.flush();
					frame.pullMessage.setText(frame.pullMessage.getText() + "내가 보낸 메세지 : " + pushMessage + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}

	public static void main(String[] args) {
		new ServerFile();
	}
}
