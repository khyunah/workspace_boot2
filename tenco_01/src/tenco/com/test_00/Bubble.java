package tenco.com.test_00;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {

	// 2 단계
	private Bubble bubbleContext = this;

	private Player player;
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

	public Bubble(Player player) {
		this.player = player;
		initObject();
		initSetting();
		initThread();
	}

	private void initObject() {
		bubble = new ImageIcon("C:\\workspace_boot2\\tenco_01\\images/bubble.png");
		bubbled = new ImageIcon("C:\\workspace_boot2\\tenco_01\\images/bubbled.png");
		bomb = new ImageIcon("C:\\workspace_boot2\\tenco_01\\images/bomb.png");
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
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
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
		removeBubble();
	}

	private void removeBubble() {
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

	private void threadSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
