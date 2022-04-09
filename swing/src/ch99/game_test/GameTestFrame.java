package ch99.game_test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class GameTestFrame extends JFrame {

	GameTestJPanel panel;
	GameTestPlayerLabel playerLabel;

	public GameTestFrame() {
		initObject();
		initSetting();
		initEventListener();
	}

	private void initObject() {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel = new GameTestJPanel();
		playerLabel = new GameTestPlayerLabel();
	}

	private void initSetting() {
		add(playerLabel);
		add(panel);

		setVisible(true);
	}

	private void initEventListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					playerLabel.left();
					break;
				case KeyEvent.VK_RIGHT:
					playerLabel.right();
					break;
				case KeyEvent.VK_CONTROL:
					playerLabel.isBooster = true;
					break;
				case KeyEvent.VK_Z:
					playerLabel.isSmokeStack = true;
					new Thread(panel).start();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_CONTROL:
					playerLabel.isBooster = false;
					break;
				}
			}
		});

	}

	public static void main(String[] args) {
		new GameTestFrame();
	}
}
