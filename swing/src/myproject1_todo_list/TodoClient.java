package myproject1_todo_list;

// 사용자에게 입력받은 todo가 생성되는 작업을 위한 클래스 
public class TodoClient {

	// todo객체 생성하는 메소드 만들기
	public TodoDto userInputTodo(String todo, String todoTime) {
		TodoDto.todoIdinstance++;
		return new TodoDto(todo, todoTime);
	}
}
