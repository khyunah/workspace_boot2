package ch99;

class MyThread2 extends Thread {

	String name;

	public MyThread2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {

		MyThread2 subThread1 = new MyThread2("서브 작업자 1");
		MyThread2 subThread2 = new MyThread2("서브 작업자 2");
		MyThread2 subThread3 = new MyThread2("서브 작업자 3");
		
		subThread1.start();
		subThread2.start();
		subThread3.start();
	}
}
