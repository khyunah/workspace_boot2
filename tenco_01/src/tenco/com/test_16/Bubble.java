package tenco.com.test_16;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Moveable {

	// 1 단계
	private BubbleFrame mContext;

	// 버블 쏘는 위치 참조
	// 의존성 컴포지션 관계
	private Player player;
	// 하나의 버블만 감시할 예정
	private BackgroundBubbleObserver backgroundBubbleObserver;

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0이면 기본, 1이면 적군 가둔 상태

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	// 의존 주입 : 보통 생성자에서 주입을 받는다.
//	public Bubble(Player player) {
//		this.player = player;
//		initObject();
//		initSetting();
//		initThread();
//	}

	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.player;
		initObject();
		initSetting();
		initThread();
	}

	private void initObject() {
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
		bomb = new ImageIcon("images/bomb.png");
		backgroundBubbleObserver = new BackgroundBubbleObserver(this);
	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;

		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
//		setLocation(x, y);

		state = 0;
	}

	private void initThread() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				if (player.getPlayerWay() == PlayerWay.LFET) {
					left();
				} else {
					right();
				}
			}
		}).start();
	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			// BackgroundBubbleObserver 여기서 스레드 쓰지않고 여기서 메소드 호출할 것.
			// 현재 색상 체크
			if (backgroundBubbleObserver.checkLeftWall()) {
				left = false;
				break;
			}
			threadSleep(1);
		}
		left = false;
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if (backgroundBubbleObserver.checkRightWall()) {
				right = false;
				break;
			}
			threadSleep(1);
		}
		right = false;
		up();
	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleObserver.checkTopWall()) {
				up = false;
				break;
			}
			threadSleep(1);
		}
		up = false;
		// remove bubble 해줘야함
		removeBubble();
	}

	private void removeBubble() {
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			// 지운후 다시 그림을 그려라
			mContext.remove(this);	// 메모리에서 제거
			mContext.repaint();		// 도화지에서 그림을 다시 그려라 ( JFrame이 도화지 )
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
