package mini_project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AddressBook2 extends JFrame {

	JPanel addressTopPanel;
	JPanel addressMenuPanel;
	JPanel addressTextPanel;

	JButton addrAll_btn;
	JButton addrFriends_btn;
	JButton addrCompany_btn;
	JButton addrSchool_btn;
	JButton addrFamily_btn;
	JButton addrAdd_btn;
	
	JScrollPane scrollPane;

	public AddressBook2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("주소록 관리 프로그램");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addressTopPanel = new JPanel(new GridLayout(2, 1));
		addressTopPanel.setPreferredSize(new Dimension(getWidth(), 100));
		addressMenuPanel = new JPanel(new GridLayout(1, 4));
		addressTextPanel = new JPanel(new GridLayout(1, 1));

		addrAll_btn = new JButton("주소록");
		addrFriends_btn = new JButton("친구");
		addrCompany_btn = new JButton("회사");
		addrSchool_btn = new JButton("학교");
		addrFamily_btn = new JButton("가족");
		addrAdd_btn = new JButton("추가");
		addrAdd_btn.setPreferredSize(new Dimension(getWidth(), 30));
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new BorderLayout());

		add(addressTopPanel, BorderLayout.NORTH);
		add(addressTextPanel, BorderLayout.CENTER);
		add(addrAdd_btn, BorderLayout.SOUTH);

		addressTopPanel.add(addrAll_btn);
		addressTopPanel.add(addressMenuPanel);

		addressMenuPanel.add(addrFriends_btn);
		addressMenuPanel.add(addrCompany_btn);
		addressMenuPanel.add(addrSchool_btn);
		addressMenuPanel.add(addrFamily_btn);

	}

	private void addEventListener() {

	}

	public static void main(String[] args) {
		new AddressBook2();
	}
}
