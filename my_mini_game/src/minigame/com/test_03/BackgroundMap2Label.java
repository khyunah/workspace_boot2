package minigame.com.test_03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap2Label extends JLabel implements Runnable{

	MiniGameFrame miniGameFrame;
	
	ImageIcon backgroudMap2;
	
	int backMqp2X;
	int backMqp2y;
	
	public BackgroundMap2Label() {
		initObject();
		initSetting();
		
		new Thread(this).start();
	}

	private void initObject() {
		backgroudMap2 = new ImageIcon("images/backgroundMap2.png");
	}

	private void initSetting() {
		backMqp2X = 1000;
		backMqp2y = 0;
		setSize(1000, 500);
		setLocation(backMqp2X, backMqp2y);
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			backMqp2X = backMqp2X - 50;
			setLocation(backMqp2X, backMqp2y);
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
