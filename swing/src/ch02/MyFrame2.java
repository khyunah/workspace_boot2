package ch02;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame {

//	private BorderLayout borderLayout;
//	private JButton[] buttons = new JButton[5];
//	private String[] titles = { "북", "센터", "남", "동", "서" };
//	private String[] directions = { 
//			BorderLayout.NORTH, BorderLayout.CENTER, 
//			BorderLayout.SOUTH, BorderLayout.EAST,
//			BorderLayout.WEST };

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

		for (int i = 0; i < buttons.size(); i++) {
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
