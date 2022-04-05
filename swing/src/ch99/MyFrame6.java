package ch99;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame6 extends JFrame {
	
	JPanel panel;

	public MyFrame6() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("x, y축 이용하여 마우스리스너 구현");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(panel);
	}
	
	private void addEventListener() {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int xPoint = e.getX();
				int yPoint = e.getY();
				System.out.println("x : " + xPoint);
				System.out.println("y : " + yPoint);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("마우스 in ");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("마우스 out");
			}
		});
	}
	
	public static void main(String[] args) {
		new MyFrame6();
	}
}
