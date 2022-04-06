package thread_ex;

class PriorutuThread extends Thread {

	@Override
	public void run() {
		int sum = 0;
		Thread t = Thread.currentThread();
		System.out.println(t + "start");

		for (int i = 0; i < 15; i++) {
			sum += i;
			System.out.println("i : " + i);
			System.out.println("sum : " + sum);
		}
		System.out.println(t.getPriority() + "end");
	}
	
}

public class ThreadTest4 {

	public static void main(String[] args) {
		int i;
		for(i = Thread.MIN_PRIORITY; i <= 10; i++) {
			PriorutuThread pt = new PriorutuThread();
			pt.setPriority(i);
			pt.start();
		}
	}
}