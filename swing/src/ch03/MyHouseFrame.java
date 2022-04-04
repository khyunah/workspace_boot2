package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel1 extends JPanel {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 집
		g.drawLine(400, 100, 200, 300);
		g.drawLine(400, 100, 600, 300);
		g.drawRect(200, 300, 400, 300);
		// 창문
		g.drawRect(300, 350, 100, 100);
		g.drawLine(350, 350, 350, 450);
		g.drawLine(300, 400, 400, 400);
		// 사람
		g.drawOval(670, 400, 50, 50);
		g.drawLine(695, 450, 695, 550);
		g.drawLine(695, 450, 660, 490);
		g.drawLine(695, 450, 730, 490);
		g.drawLine(695, 550, 660, 590);
		g.drawLine(695, 550, 730, 590);

		for (int i = 0; i < 20; i++) {
			g.drawString("☆", 50*i, 40);
			g.drawString("☆", 50*i, 750);
			g.drawString("★", 20, 50 * i);
			g.drawString("★", 750, 50 * i);
		}
	}
}

public class MyHouseFrame extends JFrame {

	MyPanel1 myPanel;

	public MyHouseFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("집 만들기");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel = new MyPanel1();
		add(myPanel);
	}

	private void setInitLayout() {
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyHouseFrame();
	}
}
