package socket_ex.ch04;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile implements CallBackSendBtn {

	Socket socket;
	BufferedWriter bufferedWriter;

	final String IP = "127.0.0.1";
	final int PORT = 10000;

	BufferedReader keybordBufferedReader;

	//////////////////////////////////////////////////////////////////

	// 서버에서 보낸 메세지를 읽기 위해 버퍼 장착
	// 새로운 스레드 필요 ! !
	BufferedReader bufferedReader;
	
	///////////////////////////////////////////////////////////////////
	
	BufferedWriter saveFile;
	
	////////////////////////////////////////////////////////////////////
	
	MessageFrame frame;

	public ClientFile() {
		frame = new MessageFrame(this);
		frame.setTitle("클라이언트의 토크토크 창");
		try {
			System.out.println("1. 클라이언트 소켓 시작");
			socket = new Socket(IP, PORT);

			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println("3. 키보드 버퍼 연결");
			keybordBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("4. 키보드 입력 대기");

			// 초기화 처리
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 
			saveFile = new BufferedWriter(new FileWriter("message.txt", true));
			

			// 새로운 스레드 시작
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			// 콘솔창에서 보내는 메세지
			while (true) {
				String msg = keybordBufferedReader.readLine();
				System.out.println("내가 보낸 메세지 : " + msg);
				
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				keybordBufferedReader.close();
				bufferedReader.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 내부 클래스
	private class ReadThread implements Runnable {

		@Override
		public void run() {

			while (true) {

				try {
					String msg = bufferedReader.readLine();	// 엔터를 구분점으로 삼는다.
					System.out.println("서버로부터 받은 메세지 : " + msg);
					
					frame.pullMessage.setText(frame.pullMessage.getText() + "클라이언트가 보낸 메세지 : " + msg + "\n");
					
					// 서버에게 받은 메세지 파일에 저장해보기
					saveFile.write(msg + "\n");
					saveFile.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	@Override
	public void sendBtn(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
			
			frame.pullMessage.setText(frame.pullMessage.getText() + "내가 보낸 메세지 : " + msg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientFile();
	}
}
