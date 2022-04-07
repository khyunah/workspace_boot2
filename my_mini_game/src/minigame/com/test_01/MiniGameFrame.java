package minigame.com.test_01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGameFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;
	
	public MiniGameFrame() {
		initObject();
		initSetting();
		initEventListener();
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		setContentPane(backgroundMap);
		player = new Player();
		add(player);
	}
	
	private void initSetting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 580);
		setLocationRelativeTo(null);
		setLayout(null);
	}
	
	private void initEventListener() {
		addKeyListener(new KeyAdapter() {
			
			// 이벤트가 일어난 시점
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(!player.isLeft()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if(!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					player.down();
					break;
				default:
					break;
				}
			}
			
			// 이벤트가 끝난 시점
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
		new MiniGameFrame();
	}
}
