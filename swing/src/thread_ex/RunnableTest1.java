package thread_ex;

import javax.swing.JFrame;

// 스레드 만드는 방법 2.
// Runnable 인터페이스 구현해서 만들기
// 자바는 다중상속이 허용되지 않으므로 다른클래스를 상속한 경우
// 스레드를 만들기 위해 Runnable인터페이스가 존재하며 구현한다.

class MyRunnable1 extends JFrame implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("↗");
		}
	}
}

public class RunnableTest1 {

	public static void main(String[] args) {

		// 사용하는 방법
		MyRunnable1 myRunnable1 = new MyRunnable1();
		// Runnable을 구현한 객체는 Thread를 생성해서 매개변수에 담고
		// Thread를 시작하면 된다.
		Thread thread1 = new Thread(myRunnable1);
		thread1.start();

		Thread thread2 = new Thread(myRunnable1);
		thread2.start();
	}
}