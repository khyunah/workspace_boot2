package ch03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyComponents extends JFrame {

	// 컴포넌트안의 포함관계
	private JPanel panel;
	private JButton button;
	private JLabel label;
	JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox checkBox;

	public MyComponents() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("컴포넌트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);

		panel = new JPanel();
//		panel.setPreferredSize(getPreferredSize());
		Dimension dimension = new Dimension(300, 300);
		panel.setPreferredSize(dimension);
		System.out.println(dimension.getSize());

		button = new JButton("button");
		label = new JLabel("label");
		textField = new JTextField("hint", 20);
		passwordField = new JPasswordField(20);
		checkBox = new JCheckBox("checkBox", true);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT, 100, 200));
		// 왼쪽 오른쪽 센터 설정가능

		add(panel);
		panel.setBackground(Color.BLUE);
		panel.add(button);
		panel.add(label);
		panel.add(textField);
		panel.add(passwordField);
		panel.add(checkBox);
	}
}
