package tenco.com.test_01.ch01;

// 제네릭 설계할때는 완벽한 컴파일이 되지않음 
// ㅡ> 사용하는 시점에서 완벽하게 컴파일됨.
public class GenericPinter<T> {

	// T 라는 대체문자를 사용 ( 대부분 대문자로 )
	// E - element 
	// K - key
	// V - value
	// 아무문자 상관없음
	
	private T material; // T 자료형으로 선언한 변수 

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
}
