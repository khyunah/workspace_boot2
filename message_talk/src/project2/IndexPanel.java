package project2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lombok.Data;

@Data
public class IndexPanel extends JPanel {

	private Image backgroundImage;
	private JPanel backgroundPanel;

	private JPanel borderPanel;

	private JPanel ipPanel;
	private JPanel portPanel;
	private JPanel idPanel;

	private JLabel ipLabel;
	private JLabel portLabel;
	private JLabel idLabel;

	private JTextField inputIp;
	private JTextField inputPort;
	private JTextField inputId;

	private JButton connectBtn;

	private CallBackClientService callBackService;

	public IndexPanel(CallBackClientService callBackService) {
		this.callBackService = callBackService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		// 백그라운드 이미지 컴포넌트
		backgroundImage = new ImageIcon("images/background.png").getImage();
		backgroundPanel = new JPanel();

		// 보더 컴포넌트
		borderPanel = new JPanel();

		// IP 컴포넌트
		ipPanel = new JPanel();
		ipLabel = new JLabel("HOST IP");
		inputIp = new JTextField(10);

		// PORT 컴포넌트
		portPanel = new JPanel();
		portLabel = new JLabel("PORT NUMBER");
		inputPort = new JTextField(10);

		// ID 컴포넌트
		idPanel = new JPanel();
		idLabel = new JLabel("ID");
		inputId = new JTextField(10);

		// 로그인 버튼
		connectBtn = new JButton("Connect");
	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		// 백그라운드 이미지 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 보더 컴포넌트
		borderPanel.setBounds(100, 60, 190, 380);
		borderPanel.setLayout(null);
		borderPanel.setBackground(Color.WHITE);
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Login"));
		add(borderPanel);

		// IP 컴포넌트
		ipPanel.setBounds(30, 40, 120, 100);
		ipPanel.setBackground(new Color(0, 0, 0, 0));
		ipPanel.add(ipLabel);
		ipPanel.add(inputIp);
		borderPanel.add(ipPanel);

		// PORT 컴포넌트
		portPanel.setBounds(30, 140, 120, 100);
		portPanel.setBackground(new Color(0, 0, 0, 0));
		portPanel.add(portLabel);
		portPanel.add(inputPort);
		borderPanel.add(portPanel);

		// IP 컴포넌트
		idPanel.setBounds(30, 240, 120, 100);
		idPanel.setBackground(new Color(0, 0, 0, 0));
		idPanel.add(idLabel);
		idPanel.add(inputId);
		borderPanel.add(idPanel);

		// LoginBtn 컴포넌트
		connectBtn.setBackground(Color.WHITE);
		connectBtn.setBounds(30, 340, 120, 20);
		borderPanel.add(connectBtn);

		// 테스트 코드
		inputIp.setText("127.0.0.1");
		inputPort.setText("10000");
	}

	private void initListener() {
		connectBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if ((!inputIp.getText().equals("")) && (!inputPort.getText().equals(""))
						&& (!inputId.getText().equals(""))) {
					
					String ip = inputIp.getText();
					String stringPort = inputPort.getText();
					int port = Integer.parseInt(stringPort);
					String id = inputId.getText();
					
					callBackService.clickConnectServerBtn(ip, port, id);
				} else {
					JOptionPane.showMessageDialog(null, "입력한 정보를 확인하세요", "알림", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
	}
}
