package ch01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 호출 하는 객체 ( 호출자 == 콜리 )
// 1. 멤버변수로 징검다리 역할을 하는 인터페이스를 먼저 선언한다.
public class SubActivity extends JFrame {

	int result = 100;

	// 더하기 버튼
	JButton button1;
	
	// 마이너스 버튼
	JButton button2;

	// 값을 전달하는 버튼
	JButton button3;

	// 1. 메인액티비티와 연결하기 위한 인터페이스 선언
	ICallBackBtnAction icallBackBtnAction;
	
	// 콜리는 콜백받는 객체의 주소값을 알고 있어야 메소드가 호출 되었다고 알릴 수 있다.
	// 3. 생성자의 매개변수로 주소값을 전달받을 수 있게 한다.
	public SubActivity(ICallBackBtnAction iCallBackBtnAction) {
		this.icallBackBtnAction = iCallBackBtnAction;

		setSize(300, 300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		button1 = new JButton("더하기 버튼");
		button2 = new JButton("마이너스 버튼");
		button3 = new JButton("100 더하기");
		
		add(button1);
		add(button2);
		add(button3);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("더하기 버튼 클릭");

				// 2. 멤버변수로 선언하고 여기서 메소드를 호출해주면 
				// 생성하지 않아서 nullPoint에러 발생 ㅡ> 생성자와 멤버변수로 주소값 넣어주기
				icallBackBtnAction.clickedAddBtn();
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("마이너스 버튼 클릭");
				icallBackBtnAction.clickedMinusBtn();
			}
		});
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("100 더하기 버튼 클릭");
				icallBackBtnAction.clicked100Btn(result);
			}
		});
	}
}
