package tenco.com.test_20;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {

	private BubbleFrame mContext;

	// 2 단계
	private Bubble bubbleContext = this;

	private Player player;
	private BackgroundBubbleObserver backgroundBubbleObserver;
	private Enemy enemy;

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

	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		this.enemy = mContext.getEnemy();
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
		for (int i = 0; i < 250; i++) {
			x--;
			setLocation(x, y);
			if (backgroundBubbleObserver.checkLeftWall()) {
				left = false;
				break;
			}
			if ((Math.abs(x - enemy.getX()) < 10) && (Math.abs(y - enemy.getY()) > 0)
					&& (Math.abs(y - enemy.getY()) < 50)) {
				if (enemy.isLive()) {
					attack();
					break;
				}
			}
			threadSleep(1);
		}
		left = false;
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 250; i++) {
			x++;
			setLocation(x, y);
			if (backgroundBubbleObserver.checkRightWall()) {
				right = false;
				break;
			}
			if ((Math.abs(x - enemy.getX()) < 10) && (Math.abs(y - enemy.getY()) > 0)
					&& (Math.abs(y - enemy.getY()) < 50)) {
				if (enemy.isLive()) {
					attack();
					break;
				}
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
			
			if(state == 0) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			threadSleep(1);
		}
		up = false;
		if(state == 0) {
			removeBubble();
		}
	}

	public void removeBubble() {
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			bubbleContext = null;
			setIcon(null); // ㅡ> 전체 도화지를 다시 그리는 것이 아니라 버블하나만 다시 그리게 됨.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void attack() {
		state = 1;
		setIcon(bubbled);
		// 메모리에서 지우기
		mContext.remove(enemy); // 이미지는 지워졌지만 아직 존재
		mContext.repaint(); // 가비지 컬렉터가 즉시 발생되지 않음.
		// 적군에 상태값 부여하기
		enemy.setLive(false);
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
