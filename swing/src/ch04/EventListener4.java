package ch04;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventListener4 extends JFrame implements MouseListener {

	JLabel label1;

	public EventListener4() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("마우스 이벤트 확인");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("hello java ~~~~~~~~~! !");
		// 글자 잘리는거를 화이트 스페이스 라고 함
		add(label1);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		label1.setSize(100, 100);
		label1.setLocation(100, 100); // 사이즈를 줘야 적용이됨
	}

	private void addEventListener() {
		this.addMouseListener(this);
	}

	// 마우스가 클릭되었을때 호출
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("x 좌표값 : " + e.getX());
		System.out.println("y 좌표값 : " + e.getY());

		System.out.println("label1 width : " + label1.getBounds().width);
		System.out.println("label1 height : " + label1.getBounds().height);

		// 현재 간격을 최소화로 만들어 정확성을 높여보자.
		label1.setLocation(e.getX() - (label1.getBounds().width / 2), e.getY() - (label1.getBounds().height - 25));
		System.out.println(label1.getBounds());
	}

	// 마우스가 눌러졌을때 호출
	@Override
	public void mousePressed(MouseEvent e) {

	}

	// 마우스가 떨어졌을때 호출
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// 마우스가 어떤 영역안으로 들어왔을때 호출
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	// 마우스가 어떤영역 밖으로 나갔을때 호출
	@Override
	public void mouseExited(MouseEvent e) {

	}

	public static void main(String[] args) {
		new EventListener4();
	} // end of main
} // end of class
