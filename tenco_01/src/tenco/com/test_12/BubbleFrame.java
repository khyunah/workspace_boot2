package tenco.com.test_12;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMqp;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	private void initObject() {
		backgroundMqp = new JLabel(new ImageIcon("images/backgroundMap.png"));
		setContentPane(backgroundMqp);

		player = new Player();
		add(player);
	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {

			// 이벤트가 일어난 시점
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				case KeyEvent.VK_SPACE:
					Bubble bubble = new Bubble(player);
					add(bubble);
					break;
				default:
					break;
				}
			} // end of keyPressed

			// 키보드 해제 이벤트 처리
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				default:
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
