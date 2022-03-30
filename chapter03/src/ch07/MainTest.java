package ch07;

public class MainTest {

	public static void main(String[] args) {

		Car car1 = new Car("KIA", "k5", 4000, "White");
		Car car2 = new Car("현대", "제네시스", 6000, "Black");
		Car car3 = new Car("KIA", "k5", 3500, "Black");

		if (car1.equals(car3)) {
			System.out.println("같은 시리즈 입니다.");
		} else {
			System.out.println("다른 시리즈 입니다.");
		}
	}
}
