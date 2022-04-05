package ch06;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame8 extends JFrame {

	private BufferedImage bgImage;
	private BufferedImage imageIcon;
	private MyPanel myPanel;

	int x = 0;
	int y = 0;

	private File bgImageFile = new File("image2.png");
	private File imageIconFile = new File("icon3.png");

	public MyFrame8() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("아이콘 움직이기");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel = new MyPanel();
		add(myPanel);
		try {
			bgImage = ImageIO.read(bgImageFile);
			imageIcon = ImageIO.read(imageIconFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setInitLayout() {
		setVisible(true);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT) {
					if (x > -35) {
						x -= 5;
					}
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					if (x < 350) {
						x += 5;
					}
				} else if (keyCode == KeyEvent.VK_UP) {
					if (y > -25) {
						y -= 5;
					}
				} else if (keyCode == KeyEvent.VK_DOWN) {
					if (y < 330) {
						y += 5;
					}
				}
				repaint();
			}
		});
	}

	// 내부클래스 선언 ㅡ> paint() 재정의
	private class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(imageIcon, x, y, 150, 150, null);
		}
	}

	public static void main(String[] args) {
		new MyFrame8();
	}
}
