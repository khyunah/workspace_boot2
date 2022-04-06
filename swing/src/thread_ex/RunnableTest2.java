package thread_ex;

import javax.swing.JFrame;

class MyRunnable2 extends JFrame {
	int grade;
	
	// 익명 구현 객체
	// 내부 익명 구현 객체를 변수에 담기
	Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("-");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	// 생성자
	public MyRunnable2() {
		// 1. 생성하자마자 바로 run()실행
//		runnable.run();
	}
}

public class RunnableTest2 {

	public static void main(String[] args) {
		MyRunnable2 myRunnable2 = new MyRunnable2();
		// 2. 여기서 run()하려면
		myRunnable2.runnable.run();
	}
}
