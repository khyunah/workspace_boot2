package minigame.com.test_03;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 움직일때 마다 색깔을 감지해 내는 역할
// 색상에 따라 멈추고 착지하는거 구현할 예정
public class BackgroundMapService extends Thread {

	private BufferedImage bgMapService;
	private Player player;

	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			bgMapService = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			System.out.println("백그라운드 맵 서비스 이미지가 없습니다.");
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				// 왼쪽으로 갔을때 프레임 밖으로 나가지 않기 위해 x, y좌표로 구별하기 위한 변수
				Color leftColor = new Color(bgMapService.getRGB(player.getX(), player.getY()));
				// 오른쪽으로 //
				Color rightColor = new Color(bgMapService.getRGB(player.getX() + 50, player.getY() + 60));
				// 다운할때 바닥이 하얀색일 때만 다운할수 있도록 구별한 변수
				int bottomColor = bgMapService.getRGB(player.getX() + 25, player.getY() + 60);
				System.out.println(bottomColor);
				// 흰색이 -1의 색상 값을 가지고 있는데 흰색배경이 아닐경우에만 실행
				// 바닥이 빨강이나 파랑이면 다운할수없게 false
				if (bottomColor != -1) {
					System.out.println("-1아님/////////////");
					player.setDown(false);
				} else { // 배경이 흰색일때 다운
					if (!player.isUp() && !player.isDown()) {
						player.down();
					}
				}

				// 플레이어가 있는 위치의 색상이 빨강색이면서 왼쪽일때
				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
					player.setLeftWallCrash(true);
					player.setLeft(false);

					// 플레이어가 있는 위치의 색상이 빨강색이면서 오른쪽일때
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					player.setRightWallCrash(true);
					player.setRight(false);
				} else {
					player.setLeftWallCrash(false);
					player.setRightWallCrash(false);
				}

				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
//				System.out.println("ArrayIndexOutOfBoundsException 오류발생");
			}
		}
	}
}