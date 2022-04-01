package myproject1_todo_list;

//C R U D 를 구현하라고 강제성을 띄는 인터페이스
public interface TodoDao {

	// C
	// 추가
	public void createTodo(TodoDto todoDto);

	// R
	// 체크한 목록만보기
	public void readCheckedTodo();
	// 체크하지 않은 목록만 보기
	public void readNoCheckTodo();
	// 등록한것은 모두보기
	public void readAllTodo();
	// 할일로 검색
	public void todoSerch(String todo);

	// U
	// todo리스트 수정
	public void updateTodo(int index, TodoDto todoDto);
	// todo리스트 체크하기 기능 boolean타입?
	// 전체 목록을 뽑아주고 아이디 값을 선택하라고 하기.
	// id값이 들어있는 인덱스의 boolean을 true로 바꿔주기
	public void checkTodo(int todoNum);

	// D
	// 삭제
	public void deleteTodo(int todoNum);
}
