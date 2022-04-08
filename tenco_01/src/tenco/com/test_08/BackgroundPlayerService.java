package tenco.com.test_08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 움직일때 마다 색깔을 감지해 내는 역할 만들 클래스
public class BackgroundPlayerService implements Runnable {
	// 메인스레드는 바쁨 키보드이벤트 처리를 하기때문
	// 백그라운드에서 계속 관찰

	private BufferedImage image;
	private Player player; // 포함관계 = 컴포지션

	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 도전과제
	// 던지거나 처리 하기
	@Override
	public void run() {
		// 색상 확인
		while (true) {
//			try {
				Color leftcolor = new Color(image.getRGB(player.getX() - 10, player.getY()));
				Color rightcolor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY()));
				System.out.println("===============================");
				System.out.println("왼쪽 색상 : " + leftcolor);
				System.out.println("오른쪽 색상 : " + rightcolor);
				System.out.println("===============================");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//			} catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println("ArrayIndexOutOfBoundsException 오류가 발생했습니다.");
//			}
			
		}
	}
}
