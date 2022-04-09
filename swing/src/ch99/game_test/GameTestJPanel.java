package ch99.game_test;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameTestJPanel extends JPanel {

	GameTestFrame frame;
//	GameTestPlayerLabel playerLabel;
	
	Image backgroundImg;

	public GameTestJPanel() {
		initObject();
	}

	private void initObject() {
		backgroundImg = new ImageIcon("images/backgroundMap.png").getImage();
//		playerLabel = new GameTestPlayerLabel();
//		add(playerLabel);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), null);
	}
}
