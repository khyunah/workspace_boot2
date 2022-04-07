package tenco.com.test_03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

// 1. 윈도우 창 
// JFrame 윈도우 창은 내부에 하나의 패널을 가지고있다.
public class BubbleFrame extends JFrame {
	

	private JTextField textField;

	public BubbleFrame() {
		setSize(1000, 640);
		// 기본 패널
		getContentPane().setLayout(null);	//  null로 지정을 하면 getContentPane() 에는 위치를 지정해야만 눈에 보인다.

		JButton button = new JButton("button1");
		button.setBounds(200, 100, 80, 20);
		getContentPane().add(button);

		textField = new JTextField();
		textField.setText("안녕하세요");
		textField.setBounds(450, 200, 100, 50);
		textField.setColumns(10);
		getContentPane().add(textField);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
