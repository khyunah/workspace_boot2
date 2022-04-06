package thread_ex;

class MyCustomThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + " : " + Thread.currentThread());
		}
	}
}

public class ThreadTest3 {

	public static void main(String[] args) {

//		 프리올리티
//		 우선순위 : 0(1) ~ 10
//		 main함수는 5인데 우선순위가 중간정도라는 것.
//		 별 의미 없지만 알아두기 
//		 Thread[main,5,main] 메인이라는 이름의 함수이고, 5번째의 우선순위, 메인함수에 속해있다. 라는 뜻
		System.out.println(Thread.currentThread());
		MyCustomThread2 subthread1 = new MyCustomThread2();
		MyCustomThread2 subthread2 = new MyCustomThread2();
		MyCustomThread2 subthread3 = new MyCustomThread2();

		subthread1.start();
		subthread2.start();
		subthread3.start();
	}

//	 Thread
//	 process ㅡ> 프로그램이 실행되면 OS로부터 메모리를 할당 받아 프로세스 상태가 된다.
//	 thread ㅡ> 하나의 프로세스는 하나이상의 스레드를 가지게 되고
//	 실제 작업을 수행하는 단위는 스레드이다.
//	
//	 multi threading
//	 여러 스레드가 동시에 수행되는 프로그래밍, 여러작업을 동시에 실행하는 효과를 낸다.
//	
//	 CPU
//	 어떤 작업을 연산하는 것. 한번에 하나의 작업만 할 수 있다.
//	 스레드가 cpu에 올라가서 아주 빠른 속도로 작업자 1, 2, 3이 왔다 갔다 거리는 것이다.
//	
//	 스레드는 각각 자신만의 작업 공간을 가진다. (context, 환경정보를 가지고 있음) ㅡ> 하나의 객체

	// 각 스레드는 공유하는 자원이 생길 수 있다. ( 임계영역 , SharedResource)
	// 여러 스레드가 자원을 공유하여 작업이 수행되는 경우
	// 서로 자원을 차지하려는 race condition이 발생할 수 있어서 의도하지 않은 결과를 만들어 낼 수 있다.
	
	// 동기화 처리를 해주어야 한다.
}
