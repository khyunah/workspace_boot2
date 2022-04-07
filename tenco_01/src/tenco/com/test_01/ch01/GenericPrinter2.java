package tenco.com.test_01.ch01;

// Material 상속받은 클래스만 들어올수 있는 제한을 지정할 수 있음.
public class GenericPrinter2<T extends Material> {

	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return material.toString();
	}
}
