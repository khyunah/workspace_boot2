package myproject1_todo_list;

// to do 객체
public class TodoDto {

	public static int todoIdinstance = 0;
	private String todo;
	private String todoTime;
	private int todoId;
	// 할일을 안했을때 false
	private boolean todoCheck;
	public final String CHECK_TRUE = "O";
	public final String CHECK_FALSE = "X";

	public TodoDto(String todo, String todoTime) {
		
		this.todoId = todoIdinstance;
		this.todo = todo;
		this.todoTime = todoTime;
		this.todoCheck = false;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public boolean isTodoCheck() {
		return todoCheck;
	}

	public void setTodoCheck(boolean todoCheck) {
		this.todoCheck = todoCheck;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getTodoTime() {
		return todoTime;
	}

	public void setTodoTime(String todoTime) {
		this.todoTime = todoTime;
	}

	@Override
	public String toString() {
		String result = "";
		if (this.todoCheck == true) {
			result = CHECK_TRUE;
		} else if (this.todoCheck == false) {
			result = CHECK_FALSE;
		} else {
			result = "E";
		}
		return "[ CHECK : " + result + " | TO DO NUM : " + todoId + " | TO DO : " + todo + " | TO DO TIME : " + todoTime + " ]";
	}
}
