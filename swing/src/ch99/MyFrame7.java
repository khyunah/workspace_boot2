package ch99;

import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MyFrame7 extends JFrame {

	TextArea textArea;

	public MyFrame7() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("키 이벤트");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textArea = new TextArea();
	}

	private void setInitLayout() {
		setVisible(true);
		add(textArea);
	}

	private void addEventListener() {
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				char presChar = e.getKeyChar();
				int keyCode = e.getKeyCode();
				textArea.append("\npressed key char : " + presChar);
				textArea.append(" / pressed key code : " + keyCode + "\n");
			}

		});
	}

	public static void main(String[] args) {
		new MyFrame7();
	}
}
