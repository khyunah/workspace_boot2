package ch02;

// ArrayList 사용시 처음 사이즈 설정되어 있지 않기 때문에  for문 사용시 주의 !!!!!!!!!!!!!!
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {

	private BorderLayout borderLayout;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<String> directions = new ArrayList<String>();

	public MyFrame2() {
		initData();
		setInitLayout();
	}

	private void setArrayList() {
		titles.add("북");
		titles.add("센터");
		titles.add("남");
		titles.add("동");
		titles.add("서");

		directions.add(BorderLayout.NORTH);
		directions.add(BorderLayout.CENTER);
		directions.add(BorderLayout.SOUTH);
		directions.add(BorderLayout.EAST);
		directions.add(BorderLayout.WEST);

		for (int i = 0; i < titles.size(); i++) {
			buttons.add(new JButton(titles.get(i)));
		}
	}

	private void initData() {
		setTitle("ArrayList 이용한 BorderLayout");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout = new BorderLayout();
		setArrayList();
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(borderLayout);
		for (int i = 0; i < buttons.size(); i++) {
			this.add(buttons.get(i), directions.get(i));
		}
	}

	public static void main(String[] args) {
		new MyFrame2();
	}
}
