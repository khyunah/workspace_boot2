package myproject1_todo_list;

import java.util.ArrayList;

// 데이터를 C R U D 할수 있도록 구현하는 클래스
public class TodoMySql implements TodoDao {

	ArrayList<TodoDto> todoList = new ArrayList<>();

	public TodoMySql() {
		TodoClient client1 = new TodoClient();
		TodoDto todo1 = client1.userInputTodo("도전 과제 하기", "18시");
		TodoDto todo2 = client1.userInputTodo("아침 운동", "7시");
		TodoDto todo3 = client1.userInputTodo("강아지 산책 시키기", "11시");
		todoList.add(todo1);
		todoList.add(todo2);
		todoList.add(todo3);
	}

	/**
	 * 입력받은 문자열 공백 없애기.
	 */
	public static String removeBlankString(String str) {
		String removeBlankString = str.replace(" ", "");
		return removeBlankString;
	}

	/**
	 * todoList에 할일을 추가한다. 추가를 하고 추가한 할일을 화면에 보여준다.
	 */
	@Override
	public void createTodo(TodoDto todoDto) {
		todoList.add(todoDto);
		System.out.println("                          [ 추가 완료 ]                            \n\n");
		System.out.println(todoDto);
		System.out.println("\n\n--------------------------------------------------------------------------\n\n");
	}

	// 체크한 것만 조회
	@Override
	public void readCheckedTodo() {
		boolean flag = true;
		System.out.println("                          [ 체크 된 목록 ]                            \n\n");
		for (int i = 0; i < todoList.size(); i++) {
			if (todoList.get(i).isTodoCheck() == true) {
				flag = false;
				System.out.println(todoList.get(i));
			}
		}
		if (flag == true) {
			System.out.println("                             체크 된것 없음                             ");
		}
		System.out.println("\n\n--------------------------------------------------------------------------\n\n");

	}

	// 체크안한것만 조회
	@Override
	public void readNoCheckTodo() {
		boolean flag = true;
		System.out.println("\n                          [ 체크 안된 목록 ]                            \n\n");
		for (int i = 0; i < todoList.size(); i++) {
			if (todoList.get(i).isTodoCheck() == false) {
				flag = false;
				System.out.println(todoList.get(i));
			}
		}
		if (flag == true) {
			System.out.println("                         체크 안된것 없음                             ");
		}
		System.out.println("\n\n--------------------------------------------------------------------------\n\n");
	}

	/**
	 * todoList에 등록되어 있는 모든 할일을 조회한다.
	 */
	@Override
	public void readAllTodo() {
		System.out.println("\n\n                          [ TODO리스트 ]                            \n\n");
		for (TodoDto todoDto : todoList) {
			System.out.println(todoDto);
		}
		System.out.println("\n\n--------------------------------------------------------------------------\n\n");
	}

	/**
	 * 할일을 검색해서 조회한다.
	 */
	@Override
	public void todoSerch(String todo) {
		boolean flag = true;
		for (int i = 0; i < todoList.size(); i++) {
			String removeBlankTodo = removeBlankString(todoList.get(i).getTodo());
			if (todo.equals(removeBlankTodo)) {
				flag = false;
				System.out.println("                          [ 검색 결과 ]                            \n\n");
				System.out.println();
				System.out.println(todoList.get(i));
			}
		}
		if(flag == true) {
			System.out.println("                         검색 결과 없음                            ");
		}
		System.out.println("\n\n--------------------------------------------------------------------------\n\n");

	}

	// 할일과 시간 수정
	@Override
	public void updateTodo(int index, TodoDto todoDto) {
		System.out.println("                          [ 수정 완료 ]                            \n\n");
		todoList.get(index).setTodo(todoDto.getTodo());
		todoList.get(index).setTodoTime(todoDto.getTodoTime());
		System.out.println(todoList.get(index));
		System.out.println("\n\n--------------------------------------------------------------------------\n\n");
	}

	// todo리스트 체크하기 기능 boolean타입?
	// 전체 목록을 뽑아주고 아이디 값을 선택하라고 하기.
	// id값이 들어있는 인덱스의 boolean을 true로 바꿔주기
	@Override
	public void checkTodo(int todoNum) {
		for (int i = 0; i < todoList.size(); i++) {
			if (todoNum == todoList.get(i).getTodoId()) {
				// 체크 상태가 false면 true로
				// true이면 false로
				if (todoList.get(i).isTodoCheck() == false) {
					System.out.println("                            체크 완료                             \n\n");
					todoList.get(i).setTodoCheck(true);
				} else {
					System.out.println("                          체크 풀기 완료                             \n\n");
					todoList.get(i).setTodoCheck(false);
				}
			}
		}
	}

	// 삭제
	@Override
	public void deleteTodo(int todoNum) {
		boolean flag = true;
		for (int i = 0; i < todoList.size(); i++) {
			if (todoNum == todoList.get(i).getTodoId()) {
				flag = false;
				TodoDto dto = todoList.remove(i);
				System.out.println(dto);
				System.out.println("\n                            삭제 완료                             \n\n");
				return;
			}
		}
		if(flag == true) {
			System.out.println("\n                            삭제 실패                             \n\n");
		}
	}
}