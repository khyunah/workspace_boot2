package minigame.com.test_02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGameFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;
	
	public MiniGameFrame() {
		initData();
		initSetting();
		initEventListener();
		setVisible(true);
	}
	
	private void initData() {
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		player = new Player();
		setContentPane(backgroundMap);
		add(player);
	}
	
	private void initSetting() {
		setLayout(null);
		setLocationRelativeTo(null);
	}
	
	private void initEventListener() {
		
	}
	
	public static void main(String[] args) {
		new MiniGameFrame();
	}
}
