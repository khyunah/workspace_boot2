package minigame.com.test_01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	private boolean upNextDown;

	private final int SPEED = 4;
	private final int JUMP_HEIGHT = 2;

	private ImageIcon playerR;
	private ImageIcon playerL;
	
	

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

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}

	private void initSetting() {
		x = 80;
		y = 270;

		left = false;
		right = false;
		up = false;
		down = false;
		
		upNextDown = false;

		setIcon(playerR);
		setSize(200, 200);
		setLocation(x, y);
	}

	// 이벤트 핸들러
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					setIcon(playerL);
					x = x - SPEED;
					setLocation(x, y);
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
	public void right() {
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 버튼을 눌렸을때 right()가 실행되어 true가 되고 버튼누른 상태인 true일때
				// 계속 오른쪽으로 이동시키기 위한 while문
				// while문 쓰지않으면 누르고 있어도 처음 누른 한번에 대해서만 작동
				// while문을 처음 쓴 이유는 자연스러운 이동을 표현하기 위해서 썼다.
				// 그런데 while문을 사용하니까 눌럿다 떼어도 계속 이동
				// 그래서 boolean으로 뗏을때 멈춰주기.
				while (right) {
					setIcon(playerR);
					x = x + SPEED;
					setLocation(x, y);
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
		upNextDown = true;
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 70; i++) {
					y = y - JUMP_HEIGHT;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down();
				up = false;
			}
		}).start();
	}

	@Override
	public void down() {
		down = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (upNextDown == true) {
					for (int i = 0; i < 7; i++) {
						y = y + JUMP_HEIGHT;
						setLocation(x, y);
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					upNextDown = false;
				} else {
					for (int i = 0; i < 63; i++) {
						y = y + JUMP_HEIGHT;
						setLocation(x, y);
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				down = false;
			}
		}).start();
	}
}
