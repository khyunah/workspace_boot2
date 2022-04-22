package socket_ex.ch04;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MessageFrame extends JFrame {

	JPanel panel;
	JTextArea pullMessage;
	JTextArea pushMessage;
	JButton pushButton;
	
	CallBackSaveBtn callBackSaveBtn;

	public MessageFrame() {
		initObject();
		initSetting();
	}

	private void initObject() {
		panel = new JPanel();
		pullMessage = new JTextArea();
		pushMessage = new JTextArea();
		pushButton = new JButton("보내기");
	}

	private void initSetting() {
		setTitle("메세지 창");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(panel);
		panel.setLayout(null);

		pullMessage.setBounds(45, 20, 400, 400);
		pushMessage.setBounds(45, 440, 400, 30);

		pushButton.setBounds(200, 500, 70, 30);
		pushButton.setBackground(Color.WHITE);

		panel.add(pullMessage);
		panel.add(pushMessage);
		panel.add(pushButton);

		setVisible(true);
	}
	
	private void initListener() {
		
		pushButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String msg = pushMessage.getText();
				callBackSaveBtn.saveFile(msg);
				
			}
		});
	}

}
