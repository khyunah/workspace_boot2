package ch03_스윙;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest extends JFrame {
	
	JTable jTable;
	JScrollPane pane;

	public JTableTest() {
		initObject();
		initSetting();
	}

	private void initObject() {
		
		String[] title = {"이름", "나이", "사는곳"};
		String[][] text = {
				{"홍길동", "10살", "부산"},
				{"홍길동1", "10살", "부산"},
				{"홍길동2", "10살", "부산"},
				{"홍길동3", "10살", "부산"},
				{"홍길동4", "10살", "부산"},
				{"홍길동5", "10살", "부산"},
				{"홍길동6", "10살", "부산"}
		};
		jTable = new JTable(text, title);
		pane = new JScrollPane(jTable);
	}

	private void initSetting() {
		setTitle("테이블 연습해보기");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pane);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTableTest();
	}
}
