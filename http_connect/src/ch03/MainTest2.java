package ch03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.TodoListDto;

/**
 * 문제 2
 * @author 김현아
 *
 */
public class MainTest2 {

	public static void main(String[] args) {
		JsonObject jsonObject = new JsonObject();
		
		JsonArray array = new JsonArray();
		
		JsonObject object1 = new JsonObject();
		JsonObject object2 = new JsonObject();
		
		object1.addProperty("id", 1);
		object1.addProperty("title", "청소");
		object1.addProperty("complete", false);
		
		object2.addProperty("id", 2);
		object2.addProperty("title", "영어공부");
		object2.addProperty("complete", true);
		
		array.add(object1);
		array.add(object2);
		
		jsonObject.add("todoList", array);
		jsonObject.addProperty("server_name", "server_1");
		
		System.out.println(jsonObject);
		
		// 모델링
		Gson gson = new Gson();
		TodoListDto todoListDto1 = gson.fromJson(object1, TodoListDto.class);
		TodoListDto todoListDto2 = gson.fromJson(object2, TodoListDto.class);
		
		
	}
}
