package ch03;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyJTable extends JFrame {

	private JTable table;
	private JScrollPane jScrollPane;
	private String[] header = { "이름", "나이", "사는곳" };
	private String[][] info = { { "홍길동", "30", "서울" }, { "김철수", "20", "부산" }, { "박영희", "24", "전주" },
			{ "정나연", "21", "춘천" }, { "최미주", "33", "인천" }, { "강나나", "16", "남해" }, { "곽마마", "40", "창원" },
			{ "김미미", "19", "대구" }, { "오정수", "36", "청주" }, { "홍길동", "30", "서울" }, { "김철수", "20", "부산" },
			{ "박영희", "24", "전주" }, { "정나연", "21", "춘천" }, { "최미주", "33", "인천" }, { "강나나", "16", "남해" },
			{ "곽마마", "40", "창원" }, { "김미미", "19", "대구" }, { "오정수", "36", "청주" } };

	public MyJTable() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("JTable 만들기");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table = new JTable(info, header);
//		table.setBackground(Color.GREEN);
		jScrollPane = new JScrollPane(table);
		add(jScrollPane);
	}

	private void setInitLayout() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyJTable();
	}
}
