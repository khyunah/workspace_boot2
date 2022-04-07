package minigame.com.test_02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	int playerX;
	int playerY;

	private ImageIcon playerR;
	private ImageIcon playerL;

	private final int SPEED = 4;
	private final int JUMP_HEIGHT = 4;

	public Player() {
		initData();
		initSetting();
	}

	private void initData() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}

	private void initSetting() {
		// JLabel에 이미지를 올리려면 ImageIcon 타입이어야 하고,
		// add대신에 setIcon()을 사용하여 이미지 올려줌.
		setIcon(playerR);

		playerX = 50;
		playerY = 270;
	}

	@Override
	public void left() {
		playerX = playerX - SPEED;
		// JPanel을 이용해서 paint()로 이미지를 그릴때는 repaint()를 이용했는데
		// JLabel은 setLocation을 이용해서 이미지 위치를 다시 그려준다.
		setLocation(playerX, playerY);
	}

	@Override
	public void right() {
		playerX = playerX + SPEED;
		setLocation(playerX, playerY);
	}

	@Override
	public void up() {
		for (int i = 0; i < 70; i++) {
			playerY = playerY - JUMP_HEIGHT;
			setLocation(playerX, playerY);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void down() {
		for (int i = 0; i < 63; i++) {
			playerY = playerY + JUMP_HEIGHT;
			setLocation(playerX, playerY);
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
