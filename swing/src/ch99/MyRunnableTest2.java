package ch99;

import javax.swing.JFrame;

class MyRunnable1 extends JFrame {
	Runnable runnable = new Runnable() {
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
	};
}

public class MyRunnableTest2 {
	
	public static void main(String[] args) {
		MyRunnable1 myRunnable = new MyRunnable1();
		myRunnable.runnable.run();
	}
}
