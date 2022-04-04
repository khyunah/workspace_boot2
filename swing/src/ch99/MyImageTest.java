package ch99;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageTest extends JFrame {
	
	public MyImageTest() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("JPanel이용해서 백그라운드 이미지 불러오기");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setInitLayout() {
		setVisible(true);
//		add(new MyImagePanel());
		
	}

	class MyImagePanel extends JPanel {

		Image image;

		public MyImagePanel() {
			image = new ImageIcon("image1.jpg").getImage();
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}

	public static void main(String[] args) {
		new MyImageTest();
	}
}
