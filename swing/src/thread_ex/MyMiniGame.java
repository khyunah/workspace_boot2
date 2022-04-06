package thread_ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMiniGame extends JFrame {

	BufferedImage bagImage1;
	BufferedImage iconImage1;
	BufferedImage iconImage2;

	CustomJPanel customJPanel;
	Thread thread1;

	JPanel btnPanel;

	JButton stopBtn;
	JButton startBtn;

	File bagImage1_file = new File("image2.png");
	File iconImage1_file = new File("icon3.png");
	File iconImage2_file = new File("icon3.png");

	public MyMiniGame() {
		initData();
		setInitLayout();
		addEvevtListener();

		// 생성자에서 thread.start()하기
		thread1 = new Thread(customJPanel);
		thread1.start();
	}

	private void initData() {
		setTitle("멀티스레드 사용해서 이미지 움직이기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			bagImage1 = ImageIO.read(bagImage1_file);
			iconImage1 = ImageIO.read(iconImage1_file);
			iconImage2 = ImageIO.read(iconImage2_file);
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		customJPanel = new CustomJPanel();
		btnPanel = new JPanel(new GridLayout(1, 2));
		stopBtn = new JButton("stop");
		startBtn = new JButton("start");
	}

	private void setInitLayout() {
		setVisible(true);
		add(customJPanel);
		add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setSize(getWidth(), 100);
		btnPanel.add(stopBtn);
		stopBtn.setBackground(Color.RED);
		btnPanel.add(startBtn);
		startBtn.setBackground(Color.ORANGE);
	}

	private void addEvevtListener() {
		
		stopBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				customJPanel.gameStart = false;
			}
		});
		
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				customJPanel.gameStart = true;
			}
		});

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int icon1X;
				int icon1Y;

				// 여기서는 이미지 2번을 키이벤트로 받아서 동작시켜 주세요.
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT) {
					icon1X = (customJPanel.getIcon1XPoint() > -20) ? 0 : -5;
					customJPanel.setIcon1XPoint(icon1X);
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					icon1X = (customJPanel.getIcon1XPoint() < 500) ? 0 : +5;
					customJPanel.setIcon1XPoint(icon1X);
				} else if (keyCode == KeyEvent.VK_UP) {
					icon1Y = (customJPanel.getIcon1YPoint() > -10) ? 0 : +5;
					customJPanel.setIcon1YPoint(icon1Y);
				} else if (keyCode == KeyEvent.VK_DOWN) {
					icon1Y = (customJPanel.getIcon1YPoint() < 550) ? 0 : -5;
					customJPanel.setIcon1YPoint(icon1Y);
				}
				repaint();
			}
		});
	}

	private class CustomJPanel extends JPanel implements Runnable {
		boolean gameStart = true;
		private int icon1XPoint = 100;
		private int icon1YPoint = 100;
		private int icon2XPoint = 300;
		private int icon2YPoint = 400;

		public int getIcon1XPoint() {
			return icon1XPoint;
		}

		public void setIcon1XPoint(int icon1xPoint) {
			icon1XPoint += icon1xPoint;
		}

		public int getIcon1YPoint() {
			return icon1YPoint;
		}

		public void setIcon1YPoint(int icon1yPoint) {
			icon1YPoint += icon1yPoint;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bagImage1, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(iconImage1, icon1XPoint, icon1YPoint, 100, 100, null);
			g.drawImage(iconImage2, icon2XPoint, icon2YPoint, 100, 100, null);
		}

		@Override
		public void run() {
			boolean direction = true;
			while (true) {
				// 이미지 3번을 좌우로
				// x좌표 값을 +
				// max좌표값을 확인하고 x좌표값을 -
				// 그림을 다시 그려주세요.
				// thread.sleep 사용
//				System.out.println("와일문");
				if(gameStart) {
					if (direction) {
						icon2XPoint += 5;
					} else {
						icon2XPoint -= 5;
					}
					
					if (icon2XPoint == 500) {
						direction = false;
					}
					if (icon2XPoint == 100) {
						direction = true;
					}
					try {
						Thread.sleep(200);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				repaint();
			}
		}
	}

	public static void main(String[] args) {
		new MyMiniGame();

	}
}
