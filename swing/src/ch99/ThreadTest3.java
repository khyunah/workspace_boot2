package ch99;

import java.util.Scanner;

class MyThread3 extends Thread {
	boolean flag = true;
	@Override
	public void run() {
		while (flag) {
			System.out.println("스레드 run() 멈추기 테스트");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyThread3 myThread3 = new MyThread3();

		myThread3.start();

		System.out.println("멈추기 - 0번 누르세요");
		int input = scanner.nextInt();
		if(input == 0) {
			myThread3.flag = false;
		}
	}
}
