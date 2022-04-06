package thread_ex;

public class ThreadTest1 {

	// 메인함수 ( 코드의 시작접 )
	// 메인 스레드가 동작하는 부분
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			System.out.println(i + "\t");
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
