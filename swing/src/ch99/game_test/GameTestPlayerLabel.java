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

	boolean isSmokeStack;

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
		playerY = 430;

		isBooster = false;
		isSmokeStack = false;

		setSize(50, 50);
		setIcon(playerRImg);
		setLocation(playerX, playerY);
	}

	public void booster() {
		if (isBooster) {
			speed = 20;
		}
	}

	public void left() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				setIcon(playerLImg);
				booster();
				playerX = playerX - speed;
				setLocation(playerX, playerY);
				speed = 4;
			}
		}).start();
	}

	public void right() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				setIcon(playerRImg);
				booster();
				playerX = playerX + speed;
				setLocation(playerX, playerY);
				speed = 4;
			}
		}).start();
	}
}
