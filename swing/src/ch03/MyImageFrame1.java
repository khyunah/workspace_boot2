package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame1 extends JFrame {

	public MyImageFrame1() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("JPanel에 이미지넣기");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new ImagePanel());
	}

	private void setInitLayout() {
		setVisible(true);
	}

	private class ImagePanel extends JPanel {

		private Image image;

		public ImagePanel() {
			image = new ImageIcon("image1.jpg").getImage();
			// 여러이미지 겹치기는 못한다. 이미지 아이콘
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			// JPanel을 상속 받고 getWidth() 은 창의 크기만큼 들고와준다.
		}
	} // end of inner class

	public static void main(String[] args) {
		new MyImageFrame1();
	} // end of main
} // end of outer class
