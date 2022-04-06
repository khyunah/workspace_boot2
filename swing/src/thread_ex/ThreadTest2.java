package thread_ex;

// 방법 1. 다른 작업자를 생성하는 방법 ㅡ> 상속을 받아 run()을 구현.
class MyCustomThread extends Thread {
	String name;

	public MyCustomThread(String name) {
		this.name = name;
	}

	// Thread는 약속되어 있다.
	// Thread클래스에서 재정의한것을 다시 재정의 하고 있는 것
	// run이라는 메소드는 쓰레드가 동작을 명령 받으면 수행하는 코드영역임.
	@Override
	public void run() {
		int i;
		for (i = 0; i < 50; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {

		// 현재 쓰레드가 누구인지 확인하는 메서드
		System.out.println(Thread.currentThread());
		System.out.println("메인 쓰레드 시작");

		
		// 작업자 호출 및 작업수행 ㅡ> run()을 순서대로 호출해도 실제작업은 랜덤
		// 작업자1 만들기
		MyCustomThread subThread1 = new MyCustomThread("서브 작업자1");

		// 쓰레드를 시작하는 방법
		// start()메소드를 호출하면 run()메소드가 호출된다.
		subThread1.start();

		// 작업을 서브작업자에게 맡기고 메인은 자기 할일 먼저 다한다.
		// 그래서 순서를 보면 메인작업자 먼저 다 끝나 있고
		// 스레드는 후에 돌아가고 있음.
		// 스레드 순서는 컨트롤할 수 없음.

		// 작업자2 만들기
		MyCustomThread subThread2 = new MyCustomThread("서브 작업자2");
		subThread2.start();

		// 작업자3 만들기
		MyCustomThread subThread3 = new MyCustomThread("서브 작업자3");
		subThread3.start();

		System.out.println("메인 쓰레드 종료");
	}
}