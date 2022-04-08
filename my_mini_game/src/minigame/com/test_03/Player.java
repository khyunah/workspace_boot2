package minigame.com.test_03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	int playerX;
	int playerY;

	private ImageIcon playerR;
	private ImageIcon playerL;

	private final int SPEED = 4;
	private final int JUMP_HEIGHT = 2;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private boolean leftWallCrash;
	private boolean rightWallCrash;

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public Player() {
		initData();
		initSetting();
		initBackgroundPlayerService();
	}
	
	private void initBackgroundPlayerService() {
		new BackgroundMapService(this).start();
	}

	private void initData() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}

	private void initSetting() {
		playerX = 50;
		playerY = 270;

		left = false;
		right = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;

		// JLabel에 이미지를 올리려면 ImageIcon 타입이어야 하고,
		// add대신에 setIcon()을 사용하여 이미지 올려줌.
		setIcon(playerR);
		// 위치와 크기를 지정해주어야 화면에 나타남
		setSize(50, 60);
		setLocation(playerX, playerY);
	}

	// Thread 사용하는 이유 : 애니메이션 효과를 내기위해
	// 사용하지 않으면 영상처럼 움직이는게 아닌 이동한 만큼의 위치로 바로 나타나기 때문
	@Override
	public void left() {
		System.out.println("left들어옴");
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("run들어옴");
				// Thread를 구현한 상태에서 while문을 사용하는 이유 :
				// Thread생성이 계속 되는 것을 막기위해.
				// 키를 계속 누르고 있으면 일정시간만에 다시 이벤트가 일어나는데, 계속 left()를 실행호출하여
				// Thread가 엄청 많아지고 더 빠른속도로 작업을 한다.
				// 무한 반복을 하기때문에 키보드 한번만 길게 누르면 무한 반복해서 화면 밖으로 사라짐
				// 그래서 boolean 변수를 주어 while문에게 멈추고 떼고를 알려주었다.
				// keyReleased()를 이용해서 키보드에 손을 떼면 while문이 멈추게끔 해야한다. ㅡ> boolean 변수 존재이유
				while (left) {
					System.out.println("while문 들어옴");
					setIcon(playerL);
					playerX = playerX - SPEED;
					// JPanel을 이용해서 paint()로 이미지를 그릴때는 repaint()를 이용했는데
					// JLabel은 setLocation을 이용해서 이미지 위치를 다시 그려준다.
					setLocation(playerX, playerY);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		System.out.println("left 끝");
	}

	@Override
	public void right() {
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					setIcon(playerR);
					playerX = playerX + SPEED;
					setLocation(playerX, playerY);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void up() {
		System.out.println("up들어옴");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("run들어옴");
				for (int i = 0; i < 90; i++) {
					playerY = playerY - JUMP_HEIGHT;
					setLocation(playerX, playerY);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("for문 나옴");
				up = false;
				down();
				System.out.println("down후");
			}
		}).start();
	}

	@Override
	public void down() {
		System.out.println("down들어옴");
		down = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("run들어옴");
				while (down) {
					playerY = playerY + JUMP_HEIGHT;
					setLocation(playerX, playerY);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
				System.out.println("1111");
			}
		}).start();
	}
}
