package mini_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddressBook extends JFrame {

	FlowLayout flowLayout;

	JPanel addressMainPanel;
	JPanel addressMenuPanel;
	JPanel addressBoardPanel;

	JButton addrAll_btn;
	JButton addrFriends_btn;
	JButton addrCompany_btn;
	JButton addrSchool_btn;
	JButton addrFamily_btn;
	JButton addrAdd_btn;

	public AddressBook() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("주소록 관리 프로그램");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension dimension;

		addressMainPanel = new JPanel(new BorderLayout());
		addressMainPanel.setPreferredSize(new Dimension(getWidth(), 50));
		addressMenuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		addressMenuPanel.setPreferredSize(new Dimension(getWidth(), 50));
		addressMenuPanel.setBackground(Color.WHITE);

//		addressBoardPanel = new JPanel();

//		flowLayout = new FlowLayout();

		addrAll_btn = new JButton("주소록");
		addrAll_btn.setPreferredSize(new Dimension(getWidth(), 50));

		addrFriends_btn = new JButton("친구");
		addrCompany_btn = new JButton("회사");
		addrSchool_btn = new JButton("학교");
		addrFamily_btn = new JButton("가족");

//		addrAdd_btn = new JButton("추가");
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new BorderLayout());

//		addressMainPanel.add(addrAll_btn, BorderLayout.NORTH);
//		addressMainPanel.setSize(getWidth(), getHeight());

		add(addressMainPanel);
		addressMainPanel.add(addrAll_btn, BorderLayout.NORTH);

		add(addressMenuPanel);

		addressMenuPanel.add(addrFriends_btn);
		addressMenuPanel.add(addrCompany_btn);
		addressMenuPanel.add(addrSchool_btn);
		addressMenuPanel.add(addrFamily_btn);
//		
	}

	private void addEventListener() {

	}

	public static void main(String[] args) {
		new AddressBook();
	}
}
