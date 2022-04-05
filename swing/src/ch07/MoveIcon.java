package ch07;
////////////////////////////////수정하기
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveIcon extends JFrame implements KeyListener {

	private BufferedImage bgImage;
	private BufferedImage imgIcon;
	private ImagePanel imagePanel;
	JPanel iconPanel;

	private String bgImageFileName = "image1.jpg";
	private String imgIconFileName = "icon2.png";

	int xPoint = 200;
	int yPoint = 200;

	public MoveIcon() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("아이콘 이동하기");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			bgImage = ImageIO.read(new File(bgImageFileName));
			imgIcon = ImageIO.read(new File(imgIconFileName));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		imagePanel = new ImagePanel();
		iconPanel = new JPanel();
		
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(imagePanel);
	}

	private void addEventListener() {
		this.addKeyListener(this);
	}

	private class ImagePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(imgIcon, xPoint, yPoint, 100, 100, null);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP) {
			yPoint = (yPoint < 0) ? 0 : yPoint - 10;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			yPoint = (yPoint < 400) ?  yPoint + 10 : 400;
		} else if (keyCode == KeyEvent.VK_LEFT) {
			xPoint -= 10;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			xPoint += 10;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public static void main(String[] args) {
		new MoveIcon();
	}
}
