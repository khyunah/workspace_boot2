package tenco.com.test_13;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

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
