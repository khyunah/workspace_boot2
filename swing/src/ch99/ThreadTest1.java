package ch99;

class MyThread extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-");
	}
}

public class ThreadTest1 {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}
}
