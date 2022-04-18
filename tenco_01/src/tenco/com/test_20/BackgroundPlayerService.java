package tenco.com.test_20;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private List<Bubble> bubbles = new ArrayList<Bubble>();

	public BackgroundPlayerService(Player player) {
		this.player = player;
		this.bubbles = player.getBubbles();
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

				// 1. 버블 충돌 체크
				for (int i = 0; i < bubbles.size(); i++) {
					Bubble targetBubble = bubbles.get(i);
					if (targetBubble.getState() == 1) {
						if ((Math.abs(player.getX() - targetBubble.getX()) < 10)
								&& (Math.abs(player.getY() - targetBubble.getY()) > 0)
								&& (Math.abs(player.getY() - targetBubble.getY()) < 50)) {
							System.out.println("플레이어와 물방울 충돌");
							new Thread(new Runnable() {

								@Override
								public void run() {
									targetBubble.removeBubble();
								}
							}).start();
							break;
						}
					}
				}

				Color leftcolor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightcolor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);

				if (bottomColor != -2) {
					player.setDown(false);
				} else {
					if (!player.isUp() && !player.isDown()) {
						player.down();
					}
				}

				if (leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0) {
					player.setLeftWallCrash(true);
					player.setLeft(false);
				} else if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0) {
					player.setRightWallCrash(true);
					player.setRight(false);
				} else {
					player.setLeftWallCrash(false);
					player.setRightWallCrash(false);
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ArrayIndexOutOfBoundsException 오류가 발생했습니다.");
			}
		}
	}
}
