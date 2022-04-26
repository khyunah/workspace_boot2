package project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import lombok.Data;

@Data
public class ClientFrame extends JFrame implements ActionListener {

	private String name;

	private JTabbedPane tabPane;
	private JPanel panel;

	// 로그인 창
	private IndexPanel indexPanel;

	// 대기실 창
	private WaitingRoomPanel waitingRoomPanel;

	// 메세지 창
	private MessagePanel messagePanel;

	// 기능 인터페이스
	private CallBackService callBackService;

	public ClientFrame(CallBackService callBackService) {
		this.callBackService = callBackService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		indexPanel = new IndexPanel(callBackService);
		waitingRoomPanel = new WaitingRoomPanel(callBackService);
		messagePanel = new MessagePanel(callBackService);
		tabPane = new JTabbedPane(JTabbedPane.TOP);
		panel = new JPanel();
	}

	private void initSetting() {
		setTitle("[ KHA Talk ]");
		setSize(400, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);

		tabPane.setBounds(0, 0, getWidth(), getHeight());
		panel.add(tabPane);

		indexPanel.setLayout(null);
		tabPane.addTab("로그인", null, indexPanel, null);

		tabPane.addTab("대기실", null, waitingRoomPanel, null);

		tabPane.addTab("채팅", null, messagePanel, null);

		setVisible(true);
	}

	private void initListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
