package lotto_game;

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

	Random random = new Random();
	
	private JButton startButton;
	private JPanel panel;

	private int[] lottoNumbers = new int[6];
	private Color[] lottoColors = new Color[6];

	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("로또 번호 생성기");
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startButton = new JButton("로또 번호 확인");
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));

		startButton.setBackground(Color.WHITE);
		panel.setBackground(Color.WHITE);
	}

	private void setInitLayout() {
		setVisible(true);
		add(panel);
		panel.add(startButton);
	}

	private void addEventListener() {
		startButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lottoNumbers = getLotto();
		lottoColors = getLottoColor();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.ORANGE);
		Font font = new Font("나눔고딕", Font.BOLD, 20);
		g.setFont(font);

		if (lottoNumbers[0] == 0) {
			g.drawString("로또버튼을 클릭하세요", 130, 180);
			return;
		}

		for (int i = 0; i < lottoNumbers.length; i++) {
			g.drawString(lottoNumbers[i] + "", 60 * (i + 1), 180);
			g.drawOval(62 * (i + 1) - 20, 150, 45, 45);
			g.setColor(lottoColors[i]);
		}
	}

	public Color[] getLottoColor() {
		Color color[] = new Color[6];
		for (int i = 0; i < color.length; i++) {
			int r = random.nextInt(255) + 1;
			int g = random.nextInt(255) + 1;
			int b = random.nextInt(255) + 1;
			Color color2 = new Color(r, g, b);
			color[i] = color2;
		}
		return color;
	}

	public int[] getLotto() {
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			int j = random.nextInt(45) + 1;
			lotto[i] = j;
			for (int e = 0; e < i; e++) {
				if (lotto[i] == lotto[e]) {
					// 반복문 그 i번째를 다시 한번 돌리기 위해 i - 1 해주는거
					i = i - 1;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		return lotto;
	}

	public static void main(String[] args) {
		new LottoFrame();
	}
}
