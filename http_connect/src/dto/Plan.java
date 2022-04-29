package dto;

import java.util.ArrayList;
import java.util.List;

public class Plan {
	private List<TodoListDto> todoList = new ArrayList<TodoListDto>();
	private String server_name;	// 키값은 반드시 똑같아야 한다.
	
	public List<TodoListDto> getTodoList(){
		return this.todoList;
	}
	
	public void setTodoList(List<TodoListDto> todoList) {
		this.todoList = todoList;
	}
}
