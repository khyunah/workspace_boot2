package tenco.com.test;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class MiniGame_test extends JFrame implements ActionListener {
	// ActionListener를 익명구현객체로 하지 않고 클래스에 구현한 이유는
	// 버튼 두개에 대한 이벤트를 한번에 처리하기 위함.

	// JPanel을 상속받아 패널 역할을 하는 클래스
	// 이미지를 패널에 그려주는 paint()가 구현되어 있음.
	private MiniGamePanel miniGamePanel;

	// 버튼을 올리기 위한 패널
	private JPanel btnPanel;

	private JButton startBtn;
	private JButton stopBtn;

	private boolean isRun;

	private BufferedImage backgroundMap;

	private BufferedImage player;
	private BufferedImage playerR;
	private BufferedImage playerL;

	private BufferedImage enemy;
	private BufferedImage enemyR;
	private BufferedImage enemyL;

	// player의 위치 바꿔주기 위한 x, y 좌표
	private int playerX;
	private int playerY;

	// enemy의 위치 바꿔주기 위한 x, y 좌표
	private int enemyX;
	private int enemyY;

	public MiniGame_test() {
		initData();
		initSetting();
		initEventListener();

		new Thread(miniGamePanel).start();
	}

	private void initData() {
		setSize(600, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 파일을 불러와 변수에 저장하는 작업
		try {
			backgroundMap = ImageIO.read(new File("images/backgroundMap.png"));

			playerR = ImageIO.read(new File("images/playerR.png"));
			playerL = ImageIO.read(new File("images/playerL.png"));
			player = playerR;

			enemyR = ImageIO.read(new File("images/enemyR.png"));
			enemyL = ImageIO.read(new File("images/enemyL.png"));
			enemy = enemyR;
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}

		// 패널을 생성한다.
		miniGamePanel = new MiniGamePanel();

		btnPanel = new JPanel();

		startBtn = new JButton("start");
		stopBtn = new JButton("stop");
	}

	private void initSetting() {
		// player의 초기위치 설정
		playerX = 100;
		playerY = 160;

		// enemy의 초기위치 설정
		enemyX = 100;
		enemyY = 495;

		// 버튼을 눌렸을때 run()을 stop하고 start하기 위한 boolean
		// start = true, stop = false
		isRun = true;

		// 생성한 패널을 JFrame에 올리기
		add(miniGamePanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);

		startBtn.setBackground(Color.ORANGE);
		stopBtn.setBackground(Color.RED);

		btnPanel.add(startBtn);
		btnPanel.add(stopBtn);
		
		// setVisible의 위치 중요함.
		// 생성자에 넣으면 작동이 제대로 하지 않음
		setVisible(true);
		this.requestFocusInWindow();
	}

	private void initEventListener() {

		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);

		// JFrame에 keyEvent가 일어나면 작동할 익명 구현 객체
		this.addKeyListener(new KeyAdapter() {

			// key를 누르면 발생하는 작업
			// player의 위치를 이동시키기 위한 메소드
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					player = playerL; // player의 이미지 방향을 바꿔주기 위함
					playerX -= 4;
					break;
				case KeyEvent.VK_RIGHT:
					player = playerR; // player의 이미지 방향을 바꿔주기 위함
					playerX += 4;
					break;
				case KeyEvent.VK_UP:
					playerY -= 4;
					break;
				case KeyEvent.VK_DOWN:
					playerY += 4;
					break;
				}
				repaint(); // x, y 좌표의 값을 변경한 뒤에 miniGamePanel에 paintComponent를
							// 다시 그려라는 repaint()를 호출하면 paintComponent() 이것이 다시 실행
			}
		});
		this.requestFocusInWindow();
	}

	// addActionListener를 사용해서 이벤트가 일어나면 이쪽으로 알려준다.
	// ActionListener를 구현했기 때문.
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton actionBtn = (JButton) e.getSource();
		// startBtn에는 getSource()와 같이 정의 되어있다.
		// getSource()로 어느 버튼을 눌렸는지 알수 있음.
		if (actionBtn == startBtn) {
			isRun = true;
		} else if (actionBtn == stopBtn) {
			isRun = false;
		}
		this.requestFocusInWindow();
	}

	private class MiniGamePanel extends JPanel implements Runnable {

		// JPanel에 이미지를 그려주는 메소드
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundMap, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(player, playerX, playerY, 50, 50, null);
			g.drawImage(enemy, enemyX, enemyY, 50, 50, null);
		}

		// keyEvent에서 일어나는 작업과 동시에 이루어 지는 것이기 때문에 Thread의 run()메소드에 정의
		@Override
		public void run() {
			// 오른쪽 방향이 true
			boolean direction = true;

			// enemy는 무한 반복
			while (true) {

				// 버튼을 눌렀을때 정지할건지 계속 반복 할건지 확인하는 if문
				if (isRun) {

					if (direction) {
						enemyX += 10;
						if (enemyX == 500) {
							enemy = enemyL;
							direction = false;
						}
					} else {
						enemyX -= 10;
						if (enemyX == 20) {
							enemy = enemyR;
							direction = true;
						}
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
	}

	public static void main(String[] args) {
		new MiniGame_test();
	}
}