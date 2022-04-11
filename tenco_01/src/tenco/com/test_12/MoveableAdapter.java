package tenco.com.test_12;

// adapter = 필터 
// 30볼트의 어댑터를 10볼트만 쓸거라고 수정할 수 있음.
public abstract class MoveableAdapter implements Moveable {

	@Override
	public void left() {}

	@Override
	public void right() {}

	@Override
	public void up() {}

	@Override
	public void down() {}
}
