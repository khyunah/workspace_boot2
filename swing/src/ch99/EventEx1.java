package ch99;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventEx1 extends JFrame implements ActionListener {

	private JButton button1;
	private JButton button2;

	public EventEx1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("버튼 눌렸을때 이벤트 확인");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		add(button1);
		add(button2);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new GridLayout(2, 1));
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " 클릭했음");
	}

	public static void main(String[] args) {
		new EventEx1();
	}
}
