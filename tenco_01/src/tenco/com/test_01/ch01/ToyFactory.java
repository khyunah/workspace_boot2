package tenco.com.test_01.ch01;

public class ToyFactory<T extends ToyMaterial> {

	private T toyMaterial;

	public T getToyMaterial() {
		return toyMaterial;
	}

	public void setToyMaterial(T toyMaterial) {
		this.toyMaterial = toyMaterial;
	}

	@Override
	public String toString() {
		return getToyMaterial().toString();
	}
}
