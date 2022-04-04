package ch03;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 메인에서 파일을 받아올 수 있도록 수정 해보기
public class MyImageFrame2_1 extends JFrame {

	private BufferedImage bacgroundImage;
	private BufferedImage imageIcon;
	private MyImegePanel myImagePanel;
	private File image1;
	private File icon1;

	public final static int BACGROUND_WIDTH = 500;
	public final static int BACGROUND_HEIGHT = 500;
	public final static int IMAGE_WIDTH = 500;
	public final static int IMAGE_HEIGHT = 500;
	public final static int ICON_WIDTH = 150;
	public final static int ICON_HEIGHT = 150;

	public MyImageFrame2_1(File image1, File icon1) {
		this.image1 = image1;
		this.icon1 = icon1;
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지 백그라운드 연습");
		setSize(BACGROUND_WIDTH, BACGROUND_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			bacgroundImage = ImageIO.read(image1);
			imageIcon = ImageIO.read(icon1);
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		myImagePanel = new MyImegePanel();
		add(myImagePanel);
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
	}

	private class MyImegePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bacgroundImage, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, null);
			g.drawImage(imageIcon, 0, 0, ICON_WIDTH, ICON_HEIGHT, null);
		}
	} // end of inner class
} // end of outer class
