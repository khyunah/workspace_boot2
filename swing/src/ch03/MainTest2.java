package ch03;

import java.io.File;

public class MainTest2 {

	public static void main(String[] args) {
		File iamge1 = new File("image1.jpg");
		File icon1 = new File("icon2.png");

		new MyImageFrame2_1(iamge1, icon1);
	}
}