package ch03;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 레이아웃 지정하지 않으면 보더가 기본
public class MyImageFrame2 extends JFrame {
	
	private BufferedImage bacgroundImage;
	private BufferedImage imageIcon;
	private MyImegePanel myImagePanel;
	
	private File image1 = new File("image1.jpg");

	public MyImageFrame2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지 백그라운드 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 파일을 못찾을수 있기에 예외처리
		try {
			// 파일 입출력 하는거 ImageIO
			// 파일 객체 따로 생성해서 객체를 매개변수로 넣어줘도됨.
			bacgroundImage = ImageIO.read(new File("image1.jpg"));
			imageIcon = ImageIO.read(new File("icon2.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		myImagePanel = new MyImegePanel();
		add(myImagePanel);
	}

	private void setInitLayout() {
		setVisible(true);
		// 프레임 창의 크기를 늘릴수 없도록 설정. 기본값은 true
		setResizable(false);
	}

	private class MyImegePanel extends JPanel {
		// 이미지 두개를 그려주는 기능을 완료하기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bacgroundImage, 0, 0, 500, 500, null);
			g.drawImage(imageIcon, 0, 0, 150, 150, null);
		}
	} // end of inner class

	public static void main(String[] args) {
		new MyImageFrame2();
	} // end of main
} // end of outer class
