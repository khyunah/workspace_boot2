package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 외부클래스
public class MyPaint extends JFrame {

	MyPanel myPanel;

	public MyPaint() {
		initData();
		setIniLayout();
	}

	private void initData() {
		setTitle("직접 그려보기 연습");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel = new MyPanel();
		add(myPanel);
	}

	private void setIniLayout() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyPaint();
	}

	// 내부 클래스
	private class MyPanel extends JPanel {
		// 이 외부 클래스에서만 사용되어 질 것이기때문에
		// 내부 클래스로 사용.

		@Override
		public void paint(Graphics g) {
			super.paint(g); // 무조건 있어야함. 지우지 말기
			g.drawString("안녕 Java  2D ~ ", 100, 200);
			g.drawLine(20, 30, 100, 100);
			g.drawRect(100, 100, 150, 150);
		}
	} // end of inner class
} // end of class
