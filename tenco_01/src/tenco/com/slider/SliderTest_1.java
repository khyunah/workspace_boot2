package tenco.com.slider;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SliderTest_1 extends JFrame {

	private JLabel carImag;

	private int x;
	private int y;

	public SliderTest_1() {
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		carImag = new JLabel(new ImageIcon("images/car1.png"));

	}

	private void initSetting() {
		x = 0;
		y = 0;

		setContentPane(carImag);

		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				new Thread(new Runnable() {

					@Override
					public void run() {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_RIGHT:

							for (int i = 0; i < 100; i++) {
								x++;
								carImag.setLocation(x, y);
							}
							break;
						}
					}
				}).start();
			}
		});
	}

	public static void main(String[] args) {
		new SliderTest_1();
	}
}
