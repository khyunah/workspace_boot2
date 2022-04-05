package mini_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddressBook1 extends JFrame {

	JPanel addrTopPanel, addrMenuPanel, addrBoardPanel;
	JButton addrAll_btn, addrFriends_btn, addrCompany_btn, addrSchool_btn, addrFamily_btn, addrAdd_btn;
//	ArrayList<JLabel> addrBookList = new ArrayList<>();

	TextArea area;
	JScrollPane jScrollPane;

	public AddressBook1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("주소록 메인");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addrTopPanel = new JPanel(new GridLayout(2, 1));
		addrMenuPanel = new JPanel(new GridLayout(1, 4));
		addrBoardPanel = new JPanel(new BorderLayout());
		addrBoardPanel.setBackground(Color.WHITE);

		addrAll_btn = new JButton("주소록 전체");
		addrFriends_btn = new JButton("친구");
		addrCompany_btn = new JButton("회사");
		addrSchool_btn = new JButton("학교");
		addrFamily_btn = new JButton("가족");
		addrAdd_btn = new JButton("추가");

		jScrollPane = new JScrollPane();
	}

	private void setInitLayout() {
		setVisible(true);

		// 위쪽 메뉴 버튼
		add(addrTopPanel, BorderLayout.NORTH);
		add(addrMenuPanel);

		addrTopPanel.add(addrAll_btn);
		addrTopPanel.add(addrMenuPanel);

		addrMenuPanel.add(addrFriends_btn);
		addrMenuPanel.add(addrCompany_btn);
		addrMenuPanel.add(addrSchool_btn);
		addrMenuPanel.add(addrFamily_btn);

		// 리스트와 추가 버튼
		add(addrBoardPanel, BorderLayout.CENTER);
//		addrBoardPanel.add(jScrollPane);
		addrBoardPanel.add(addrAdd_btn, BorderLayout.SOUTH);

	}

	private void addEventListener() {

	}

	public static void main(String[] args) {
		new AddressBook1();
	}
}
