package thread_ex;

class BankAccount {
	private int money = 100_000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 입금
	// 동기화
	// synchronized 키워드 사용
	public synchronized void saveMoney(int money) {
		int currentMoney = getMoney();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMoney(currentMoney + money);
		System.out.println("입금 후 계좌 잔액 : " + getMoney());
	}

	// 출금
	public void wirhdraw(int money) {
		synchronized (this) {
			int currentMoney = getMoney();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			setMoney(currentMoney - money);
			System.out.println("출금 후 계좌 잔액 : " + getMoney());
		}
	}
}

// 아빠는 세종시에서 입금을 한다. ( 네트워크가 느려서 시간이 좀 걸림. )
class Father extends Thread {
	BankAccount account;

	public Father(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.saveMoney(10_000);
	}
}

class Mother extends Thread {
	BankAccount account;

	public Mother(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.wirhdraw(5_000);
	}
}

public class SharedResource {

	public static void main(String[] args) {
		// 계좌 공유, 아빠는 입금, 엄마는 출금 하는 기능
		// 현재 100_000원이 저금 되어 있음
		BankAccount account = new BankAccount(); // ㅡ> SharedResource역할
		Father father = new Father(account);
		Mother mother = new Mother(account);

		// 아버지가 입금 합니다.
		father.start();
		// 어머니가 출금 합니다.
		mother.start();

		// 정상 처리 금액 10 + 1 - 0.5 = 10.5만원

//		 공유되는 자원을 활용할때 의도치 않은 결과를 생성할 수 있다.
//		 해결방법 ㅡ> 동기화 synchronization
//		 1. synchronized 메서드
//		 순서대로 실행되는데 처음 스레드가 다 진행되고 나면 후의 스레드가 실행 ㅡ> 잠근다라는 개념
//		 2. synchronized 블럭
//		 메소드안에 블록의 형태로 생성하여 그안에 동기화하고 싶은 코드 넣기
//		 차이점 ㅡ> 전체를 잠그느냐 부분을 잠그느냐.
	}
}
