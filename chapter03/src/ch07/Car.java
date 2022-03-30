package ch07;

public class Car {

	String company;
	String name;
	int price;
	String color;

	public Car(String company, String name, int price, String color) {
		this.company = company;
		this.name = name;
		this.price = price;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", name=" + name + ", price=" + price + ", color=" + color + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car tempCar = (Car) obj;
			String carName = tempCar.name;
			if (this.name == carName) {
				System.out.println(this.toString());
				System.out.println(tempCar);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
