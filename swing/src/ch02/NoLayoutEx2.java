package ch02;

// ArrayList 사용할때 size가 선언되지 않기때문에 주의 !!!!!!!!!!!!
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayoutEx2 extends JFrame {

	ArrayList<JButton> buttons = new ArrayList<>();

	private JButton button1;
	private JButton button2;
	private JButton button3;

	public NoLayoutEx2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("No Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

//		for (int i = 0; i < buttons.size(); i++) {
//			buttons.add(new JButton("" + i));
//		}
		buttons.add(new JButton("1"));
		buttons.add(new JButton("2"));
		buttons.add(new JButton("3"));
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setSize(50, 50);
			buttons.get(i).setLocation(50 + (10 * i), 50 + (10 * i));
			add(buttons.get(i));
		}
	}

	public static void main(String[] args) {
		new NoLayoutEx2();
	}
}
