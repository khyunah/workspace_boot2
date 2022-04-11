package tenco.com.test_12;

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

	@Override
	public void run() {
		// 색상 확인
		while (true) {
			try {
				Color leftcolor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightcolor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
//				Color bottomColor = new Color(image.getRGB(player.getX() + 25, player.getY() + 50 + 10));
				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);

				// -1이 아니라는 것은 빨간색이거나 파란색이다.
				// 떨어지지 않는 부분
				if (bottomColor != -2) {
					player.setDown(false);
//					System.out.println("바닥 컬러 : " + bottomColor);
				} else {
					// 점프하는 순간 down()호출
					if (!player.isUp() && !player.isDown()) {
						player.down();
					}
				}
				/**
				 * 
				 * 버그!!!!!!!!!!!!!!!!
				 * 
				 * 위의 if문이 실행되고 나서 바로 당장은 아래 if문이 실행 안되고 
				 * try캐치에 슬립이 걸린다. 아까 100으로 설정해서 100을 기다린다. 0.1초  
				 * player.down()이 실행 해당 메소드에 들어가보면 내려가는속도가 3이어서
				 * 3을 무한 반복하는 중에 아래의 if문이 검사되어 실행 되어야하는데 
				 * try 캐치에서 0.1초를 기다리는 중이기때문에 검사가 늦게 진행된다.
				 * 시간차를 많이 뒀기때문에 다운이 이미 화면 밖으로 무한 반복하여 내려간 상태.
				 * try캐치에서 시간을 똑같이 맞춰 줘야함
				 * 
				 */

				if (leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0) {
//					System.out.println("왼쪽 벽에 충돌했어");
					player.setLeftWallCrash(true);
					player.setLeft(false);
				} else if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0) {
//					System.out.println("오른쪽 벽에 충돌했어");
					player.setRightWallCrash(true);
					player.setRight(false);
				} else {
					player.setLeftWallCrash(false);
					player.setRightWallCrash(false);
				}

//				System.out.println("===============================");
//				System.out.println("왼쪽 색상 : " + leftcolor);
//				System.out.println("오른쪽 색상 : " + rightcolor);
//				System.out.println("===============================");

//				try {
//					/**
//					 * 캐릭터가 이동 될 때 값을 못 찾는 경우가 있다. 
//					 * 이동 속도보다 더 빠르게 움직여야 해결가능
//					 *  오늘 버그 : 이동시간보다 검사하는 시간이 오래걸려서 검사가되지않아
//					 *  계속 다운되는 현상 발생 
//					 */
//					Thread.sleep(3);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ArrayIndexOutOfBoundsException 오류가 발생했습니다.");
			}
		}
	}
}
