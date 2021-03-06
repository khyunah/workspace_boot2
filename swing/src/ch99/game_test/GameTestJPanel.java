package ch99.game_test;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameTestJPanel extends JPanel implements Runnable {

	GameTestFrame frame;
	GameTestPlayerLabel playerLabel;

	Image backgroundImg;
	Image backgroundImg2;

	int imgX;
	int imgY;

	public GameTestJPanel() {
		initObject();
	}

	private void initObject() {
		backgroundImg = new ImageIcon("images/backgroundMap.png").getImage();
		backgroundImg2 = new ImageIcon("images/backgroundMapService.png").getImage();
		imgX = 0;
		imgY = 0;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			imgX = imgX - 50;
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		backgroundImg = backgroundImg2;
		imgX = 1000;
		for (int i = 0; i < 20; i++) {
			imgX = imgX - 50;
			repaint();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(backgroundImg, imgX, imgY, getWidth(), getHeight(), null);
	}
}
