package ch99;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyImageTest2 extends JFrame {
	
	BufferedImage bacgroundImg;
	BufferedImage icon2;

	public MyImageTest2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("ImageIO이용해서 이미지 불러오기");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyImagePanel());
		try {
			bacgroundImg = ImageIO.read(new File("image1.jpg"));
			icon2 = ImageIO.read(new File("icon2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
	}
	
	class MyImagePanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bacgroundImg, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(icon2, 0, 0, 150, 150, null);
		}
	}

	public static void main(String[] args) {
		new MyImageTest2();
	}
}
