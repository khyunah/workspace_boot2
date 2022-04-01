package ch02;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 배열쓴것은 ArrayList로 변경 해보기 
public class MyFrame1 extends JFrame {

	private BorderLayout borderLayout;
	private JButton[] buttons = new JButton[5];
	private String[] titles = { "북", "센터", "남", "동", "서" };
	private String[] directions = { 
			BorderLayout.NORTH, BorderLayout.CENTER, 
			BorderLayout.SOUTH, BorderLayout.EAST,
			BorderLayout.WEST };

	public MyFrame1() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("BorderLayout TEST");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout = new BorderLayout();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(titles[i]); // 버튼생성자안의 문자열은 버튼 문구
		}
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(borderLayout);
		for (int i = 0; i < buttons.length; i++) {
			this.add(buttons[i], directions[i]);
		}
	}
}