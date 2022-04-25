package project2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import lombok.Data;

@Data
public class MessagePanel extends JPanel {

	private JPanel mainPanel;
	private JPanel bottomPanel;

	private JTextArea mainMessageBox;
	private JTextArea writeMessageBox;
	private JButton sendMessageBtn;

	private String messageText;
	private CallBackService callBackService;

	public MessagePanel(CallBackService callBackService) {
		this.callBackService = callBackService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		mainPanel = new JPanel();
		bottomPanel = new JPanel();

		mainMessageBox = new JTextArea("[ 채팅 ]\n", 25, 30);
		writeMessageBox = new JTextArea(2, 23);
		sendMessageBtn = new JButton("전송");
	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		mainMessageBox.setEnabled(false);
		mainPanel.setBounds(40, 20, 300, 350);
		mainPanel.add(mainMessageBox);
		add(mainPanel);

		bottomPanel.setBounds(40, 380, 300, 40);
		sendMessageBtn.setBackground(Color.WHITE);
		sendMessageBtn.setPreferredSize(new Dimension(60, 32));
		bottomPanel.add(writeMessageBox);
		bottomPanel.add(sendMessageBtn);
		add(bottomPanel);
	}

	private void initListener() {
		sendMessageBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msg = writeMessageBox.getText();
				callBackService.sendMessage(msg);
				writeMessageBox.setText("");
				mainMessageBox.append("[ 내가 보낸 메세지 ]\n" + msg + "\n");
			}
		});
	}
}
