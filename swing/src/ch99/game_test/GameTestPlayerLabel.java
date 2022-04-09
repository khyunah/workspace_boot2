package ch99.game_test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameTestPlayerLabel extends JLabel {

	ImageIcon playerRImg;
	ImageIcon playerLImg;

	int playerX;
	int playerY;
	
	int speed;
	
	boolean isBooster;
	
	

	public GameTestPlayerLabel() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerRImg = new ImageIcon("images/playerR.png");
		playerLImg = new ImageIcon("images/playerL.png");
	}

	private void initSetting() {
		playerX = 100;
		playerY = 100;
		
		isBooster = false;

		setSize(50, 50);
		setIcon(playerRImg);
		setLocation(playerX, playerY);
	}
	
	public void booster() {
		if(isBooster) {
			speed = 20;
		}
	}

	public void left() {
		setIcon(playerLImg);
		booster();
		playerX = playerX - speed;
		setLocation(playerX, playerY);
		speed = 4;
	}
	
	public void right() {
		setIcon(playerRImg);
		booster();
		playerX = playerX + speed;
		setLocation(playerX, playerY);
		speed = 4;
	}
}
