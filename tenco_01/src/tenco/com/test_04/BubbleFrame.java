package tenco.com.test_04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMqp;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
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
		setLayout(null);	// 좌표값으로 자유롭게 그릴수 있다. absolute 개념
		setLocationRelativeTo(null);	// 윈도우창 가운데에 배치하기 null로 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
