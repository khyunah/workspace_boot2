package ch99;

import javax.swing.JFrame;

class MyRunnable extends JFrame implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("스레드동작 " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MyRunnableTest1 {

	public static void main(String[] args) {

		MyRunnable myRunnable = new MyRunnable();
		myRunnable.run();
		
		Thread thread = new Thread(myRunnable);
		thread.start();
	}
}
