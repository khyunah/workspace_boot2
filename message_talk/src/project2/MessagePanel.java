package project2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lombok.Data;

@Data
public class MessagePanel extends JPanel {

	private Image backgroundImage;
	private JPanel backgroundPanel;

	private JPanel mainPanel;
	private JPanel bottomPanel;

	private JTextArea mainMessageBox;
	private JTextField writeMessageBox;
	private JButton sendMessageBtn;

	private String messageText;
	private CallBackClientService callBackService;

	public MessagePanel(CallBackClientService callBackService) {
		this.callBackService = callBackService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		backgroundImage = new ImageIcon("images/background.png").getImage();
		backgroundPanel = new JPanel();

		mainPanel = new JPanel();
		bottomPanel = new JPanel();

		mainMessageBox = new JTextArea(20, 25);
		writeMessageBox = new JTextField(17);
		sendMessageBtn = new JButton("전송");
	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setLayout(null);
		add(bottomPanel);

		mainMessageBox.setEnabled(false);
		mainPanel.setBounds(40, 20, 300, 350);
		mainPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Message"));
		mainPanel.setBackground(new Color(0, 0, 0, 0));
		mainPanel.add(mainMessageBox);
		add(mainPanel);

		sendMessageBtn.setBackground(Color.WHITE);
		sendMessageBtn.setPreferredSize(new Dimension(60, 20));
		bottomPanel.setBounds(43, 380, 294, 35);
		bottomPanel.setBackground(new Color(0, 0, 0, 0));
		bottomPanel.setBorder(new LineBorder(Color.BLACK, 2));
		bottomPanel.add(writeMessageBox);
		bottomPanel.add(sendMessageBtn);
		add(bottomPanel);
	}

	private void initListener() {
		sendMessageBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msg = writeMessageBox.getText();
				callBackService.clickSendMessageBtn(msg);
				writeMessageBox.setText("");
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
	}
}
