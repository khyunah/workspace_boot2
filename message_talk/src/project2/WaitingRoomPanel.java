package project2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;

@Data
public class WaitingRoomPanel extends JPanel implements ActionListener {

	private JPanel userListPanel;
	private JPanel roomListPanel;
	private JPanel roomBtnPanel;
	private JPanel sendMagPanel;

	private JLabel userListLabel;
	private JLabel roomListLabel;

	private JList<String> userList;
	private JList<String> roomList;

	private JTextField inputSecretMsg;
	private JButton secretMsgBtn;

	private JButton makeRoomBtn;
	private JButton outRoomBtn;

	private Vector<String> userIdVector = new Vector<>();
	private Vector<String> roomNameVector = new Vector<>();
	
	private String myRoomName;

	private CallBackService callBackService;
	
	public WaitingRoomPanel(CallBackService callBackService) {
		this.callBackService = callBackService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		userListPanel = new JPanel();
		roomListPanel = new JPanel();
		roomBtnPanel = new JPanel();
		sendMagPanel = new JPanel();

		userListLabel = new JLabel("User List\n");
		roomListLabel = new JLabel("Room List\n");

		userList = new JList<>();
		roomList = new JList<>();

		inputSecretMsg = new JTextField();
		secretMsgBtn = new JButton("send Message");
		makeRoomBtn = new JButton("make Room");
		outRoomBtn = new JButton("out Room");
		
	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		userListPanel.setBounds(50, 30, 120, 260);
		userListPanel.setBackground(Color.WHITE);
		userListPanel.add(userListLabel);
		userListPanel.add(userList);
		add(userListPanel);

		roomListPanel.setBounds(230, 30, 120, 260);
		roomListPanel.setBackground(Color.WHITE);
		roomListPanel.add(roomListLabel);
		roomListPanel.add(roomList);
		add(roomListPanel);

		roomBtnPanel.setBounds(50, 310, 300, 30);
		roomBtnPanel.setBackground(Color.WHITE);
		roomBtnPanel.setLayout(null);

		makeRoomBtn.setBackground(Color.WHITE);
		makeRoomBtn.setBounds(30, 5, 110, 25);

		outRoomBtn.setBackground(Color.WHITE);
		outRoomBtn.setBounds(170, 5, 100, 25);

		roomBtnPanel.add(makeRoomBtn);
		roomBtnPanel.add(outRoomBtn);
		add(roomBtnPanel);

		sendMagPanel.setBounds(50, 360, 300, 60);
		sendMagPanel.setBackground(Color.WHITE);
		sendMagPanel.setLayout(null);

		inputSecretMsg.setBounds(30, 5, 240, 25);
		secretMsgBtn.setBounds(30, 35, 240, 20);
		secretMsgBtn.setBackground(Color.WHITE);

		sendMagPanel.add(inputSecretMsg);
		sendMagPanel.add(secretMsgBtn);
		add(sendMagPanel);
	}

	private void initListener() {
		makeRoomBtn.addActionListener(this);
		outRoomBtn.addActionListener(this);
		secretMsgBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == secretMsgBtn) {
			
			String msg = inputSecretMsg.getText();
			inputSecretMsg.setText("");
			callBackService.sendSecretMessage(msg);
			
		} else if (e.getSource() == makeRoomBtn) {
			
			String roomName = JOptionPane.showInputDialog("[ 방 이름 설정 ]");
			
			if (roomName != null) {
				callBackService.makeRoom(roomName);
			}
			
		} else if (e.getSource() == outRoomBtn) {
			callBackService.outRoom();
		}
	}
}
