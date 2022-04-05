package ch05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyFrame7 extends JFrame implements KeyListener {

	private JTextArea textArea;

	public MyFrame7() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("키 이벤트 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea();
	}

	private void setInitLayout() {
		setVisible(true);
		add(textArea); // 기본값보더라 전체화면에 표시됨
	}

	private void addEventListener() {
		textArea.addKeyListener(this);
	}

	// 문자키만 반응
	@Override
	public void keyTyped(KeyEvent e) {

	}

	// 키보드를 눌렀을 때 반응
	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		int keyCode = e.getKeyCode();
		System.out.println("c : " + c);
		System.out.println("keyCode : " + keyCode);
		// 도전과제
		// textArea에 키코드 그리고 char c값을 보이게 코딩
		textArea.append("\nc :" + c + " / keyCode : " + keyCode + "\n");

		// 콘솔창에 왼쪽 화살표, 오른쪽 화살표 , 위 아래 구분해서 syso출력
		if (keyCode == KeyEvent.VK_LEFT) {
			System.out.println("왼쪽 화살표가 눌려짐");
		} else if (keyCode == KeyEvent.VK_UP) {
			System.out.println("위쪽 화살표가 눌려짐");
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			System.out.println("오른쪽 화살표가 눌려짐");
		} else if (keyCode == KeyEvent.VK_DOWN) {
			System.out.println("아래쪽 화살표가 눌려짐");
		} else {
			System.out.println("방향키 외의 버튼 눌러짐");
		}
	}

	// 키보드를 눌렀다가 뗏을때 반응
	@Override
	public void keyReleased(KeyEvent e) {

	}

	public static void main(String[] args) {
		new MyFrame7();
	}
}
