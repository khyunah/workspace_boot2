package ch05;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseActivity extends JFrame {

	JPanel panel;
	String name;

	public BaseActivity(String name) {
		this.name = name;
		initData();
		initLayout();
	}

	private void initData() {
		setTitle(this.name);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
	}

	private void initLayout() {
		setVisible(true);
		add(panel);
	}
}
