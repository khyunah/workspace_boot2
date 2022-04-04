package ch04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeColorButton extends JFrame implements ActionListener {

	JPanel jPanel1;
	JPanel jPanel2;

	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;

	public ChangeColorButton() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("버튼클릭시 색상 변경 테스트");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button1 = new JButton("빨강");
		button2 = new JButton("파랑");
		button3 = new JButton("노랑");
		button4 = new JButton("초록");

		jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 120));
		jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 120));

		jPanel1.add(button1);
		jPanel1.add(button2);
		jPanel1.setBackground(Color.BLACK);
		jPanel2.add(button3);
		jPanel2.add(button4);
		jPanel2.setBackground(Color.WHITE);

		add(jPanel1);
		add(jPanel2);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new GridLayout(2, 1));
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventBtn = e.getActionCommand();
		if(eventBtn.equals(button1.getText())) {
			jPanel1.setBackground(Color.RED);
		} else if(eventBtn.equals(button2.getText())) {
			jPanel1.setBackground(Color.BLUE);
		} else if(eventBtn.equals(button3.getText())) {
			jPanel2.setBackground(Color.YELLOW);
		} else if(eventBtn.equals(button4.getText())) {
			jPanel2.setBackground(Color.GREEN);
		}
	}

	public static void main(String[] args) {
		new ChangeColorButton();
	}
}
