package tenco.com.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniGame extends JFrame implements ActionListener {

	private BufferedImage bgImage;
	private BufferedImage playerImage;
	private BufferedImage playerImageL;
	private BufferedImage playerImageR;

	private BufferedImage enemyImage;
	private BufferedImage enemyImageL;
	private BufferedImage enemyImageR;

	private JButton startBtn;
	private JButton endBtn;
	private JPanel bottomPanel;

	private boolean isThread = true;

	private int playerX;
	private int playerY;

	private int enermyX;
	private int enermyY;

	private CustomJPanel customJPanel;

	public MiniGame() {
		initData();
		setInitLayout();
		addEventListener();

		new Thread(customJPanel).start();
	}

	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startBtn = new JButton("start");
		endBtn = new JButton("end");

		try {
			bgImage = ImageIO.read(new File("images/backgroundMap.png"));

			playerImageL = ImageIO.read(new File("images/PlayerL.png"));
			playerImageR = ImageIO.read(new File("images/PlayerR.png"));
			playerImage = playerImageR;

			enemyImageL = ImageIO.read(new File("images/enemyL.png"));
			enemyImageR = ImageIO.read(new File("images/enemyR.png"));
			enemyImage = enemyImageR;
		} catch (IOException e) {
			System.out.println("파일이 없습니다 ! !");
		}

		customJPanel = new CustomJPanel();
		bottomPanel = new JPanel(new FlowLayout());

		enermyX = 100;
		enermyY = 400;
	}

	private void setInitLayout() {
		add(customJPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		bottomPanel.add(startBtn);
		bottomPanel.add(endBtn);

		setVisible(true);
		this.requestFocusInWindow();
	}

	private void addEventListener() {

		startBtn.addActionListener(this);
		endBtn.addActionListener(this);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				// 모두 검사하지 않고 case를 바로 찾아간다. break문 무조건 넣기.
				switch (keyCode) {
				case KeyEvent.VK_UP:
					playerY -= 10;
					break;
				case KeyEvent.VK_DOWN:
					playerY += 10;
					break;
				case KeyEvent.VK_LEFT:
					playerX -= 10;
					playerImage = playerImageL;
					break;
				case KeyEvent.VK_RIGHT:
					playerX += 10;
					playerImage = playerImageR;
					break;
				}
				repaint();
			}
		});
		this.requestFocusInWindow();
	} // end of addEventListener

	private class CustomJPanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, 600, 600, null);
			g.drawImage(playerImage, playerX, playerY, 55, 55, null);
			g.drawImage(enemyImage, enermyX, enermyY, 50, 50, null);
		}

		@Override
		public void run() {
			boolean direction = true;
			while (true) {

				if (isThread) {

					if (direction) {
						enermyX += 10;
					} else {
						enermyX -= 10;
					}

					if (enermyX == 400) {
						direction = false;
						enemyImage = enemyImageL;
					}

					if (enermyX == 10) {
						direction = true;
						enemyImage = enemyImageR;
					}

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				repaint();
			}
		}
	} // end of inner class

	@Override
	public void actionPerformed(ActionEvent e) {
		// 누른버튼이 무엇인지 코드받아 온것
		JButton targetBtn = (JButton) e.getSource();
		if (startBtn == targetBtn) {
			System.out.println("d 1");
			isThread = true;
		} else {
			System.out.println("d 2");
			isThread = false;
		}
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new MiniGame();
	}
}