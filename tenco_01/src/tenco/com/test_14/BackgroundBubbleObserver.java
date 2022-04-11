package tenco.com.test_14;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// Thread 사용 안할것 ! ! !
// 왜? 느려지기 때문.
public class BackgroundBubbleObserver {

	private BufferedImage image;
	private Bubble bubble;

	// Color 멤버 변수로 만드는게 좋은가?
	// : 지역변수로 쓰는 것이 좋은 것 같다.
	// 메소드안에서만 사용할 것이기 때문.

	// 리팩토링 과정 연습

	public BackgroundBubbleObserver(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
	}

	public boolean checkLeftWall() {
		// 리팩토링
		// 1단계 방법
		Color leftColor = new Color(image.getRGB(bubble.getX(), bubble.getY()));
		if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			return true;
		}
		return false;
	}

	public boolean checkRightWall() {
		// 2단계 방법
		if(isCrashColor()) {
			return true;
		}
		return false;
	}

	public boolean checkTopWall() {
		// 3단계 방법
		return isCrashColor();
	}

	private boolean isCrashColor() {
		Color topColor = new Color(image.getRGB(bubble.getX(), bubble.getY()));
		if (topColor.getRed() == 255 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
			return true;
		}
		return false;
	}
}
