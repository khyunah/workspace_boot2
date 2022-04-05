package ch05;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

// 마우스 어댑터 기능을 사용해보자
public class MyFrame6 extends JFrame {

	public MyFrame6() {
		initData();
		setInitLayout();
		addEventLisetener();
	}

	private void initData() {
		setTitle("어댑터 클래스 사용");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setInitLayout() {
		setVisible(true);
	}

	private void addEventLisetener() {
		// 1. 클래스에 구현 
		// 2. 익명 구현 객체로 만들어내기
		// 3. 내부클래스로 정의해서 오버라이드 활용
		this.addMouseListener(new MyCustomMouseListener());
	}

	// 내부 클래스 사용
	private class MyCustomMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("x : " + x);
			System.out.println("y : " + y);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("마우스 in ");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("마우스 out");
		}
	}
	
	public static void main(String[] args) {
		new MyFrame6();
	}
}
