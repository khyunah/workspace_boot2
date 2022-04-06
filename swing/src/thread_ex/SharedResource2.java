package thread_ex;

class Store {
	private int item = 20;

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public synchronized void buy20Item() {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (item != 20) {
			System.out.println("재고가 부족하여 구매할 수 없습니다.");
			return;
		}
		setItem(item - 20);
		System.out.println("item을 " + item + "개 모두 구매 했습니다");
		System.out.println("item 재고 : " + getItem());
	}

	public synchronized void buyItem(int item) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ((this.item - item) <= 0) {
			System.out.println("재고가 부족하여 물건을 구매할 수 없습니다.");
			return;
		}
		setItem(this.item - item);
		System.out.println("item을 " + item + "개 구매 했습니다");
		System.out.println("item 재고 : " + getItem());
	}
}

class Student1 extends Thread {
	Store item;

	public Student1(Store item) {
		this.item = item;
	}

	@Override
	public void run() {
		item.buy20Item();
	}
}

class Student2 extends Thread {
	Store item;

	public Student2(Store item) {
		this.item = item;
	}

	@Override
	public void run() {
		item.buyItem(5);
	}
}

public class SharedResource2 {

	public static void main(String[] args) {
		// 가게의 총 물품 수량은 20개
		Store store = new Store();
		Student1 student1 = new Student1(store);
		Student2 student2 = new Student2(store);

		student1.start();
		student2.start();
	}
}