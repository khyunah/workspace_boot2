package lotto_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoFrame extends JFrame implements ActionListener {

	private JButton startButton;
	private int[] lottoNumbers = new int[6];
	private JPanel panel;

	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(400, 500);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startButton = new JButton("로또 번호 확인");
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
	}

	private void setInitLayout() {
		setVisible(true);
		add(panel);
		panel.add(startButton, new FlowLayout(FlowLayout.LEFT));
	}

	private void addEventListener() {
		startButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lottoNumbers = getLotto();
		// 그림을 다시 그려라
		// 밑에 호출한 paint()를 다시 호출하는것
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.ORANGE);
		Font font = new Font("나눔고딕", Font.BOLD, 20);
		g.setFont(font);

		if (lottoNumbers[0] == 0) {
			g.drawString("로또버튼을 클릭하세요", 50, 100);
			return;
		}
		// lottoNumbers[0] 값이 있다면 6개 번호를 생성한 후 번호를 그려보자.

		for (int i = 0; i < lottoNumbers.length; i++) {
			g.drawString(lottoNumbers[i] + "", 60 * (i + 1), 300);
			g.drawOval(61 * (i + 1) - 20, 270, 45, 45);
			
		}
	}

	public int[] getLotto() {
		int[] lotto = new int[6];
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			int j = random.nextInt(45) + 1;
			lotto[i] = j;
			// 뽑은 랜덤수 i만큼만 for문 반복
			for (int e = 0; e < i; e++) {
				// 같은 값이 있으면
				if (lotto[i] == lotto[e]) {
					// 반복문 그 i번째를 다시 한번 돌리기 위해 i - 1 해주는거
					i = i - 1;
					break;
				}
			}
		}

		// 정렬문제 해결
		Arrays.sort(lotto);

		for (int i : lotto) {
			System.out.println(i);
		}

		return lotto;
	}

	public static void main(String[] args) {
		new LottoFrame();
	}

}
