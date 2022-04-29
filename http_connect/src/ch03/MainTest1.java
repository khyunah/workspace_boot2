package ch03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Person;

/**
 * 문제 1
 * @author 김현아
 *
 */
public class MainTest1 {

	public static void main(String[] args) {
		JsonArray array1 = new JsonArray();
		
		JsonObject object1 = new JsonObject();
		JsonObject object2 = new JsonObject();
		JsonObject object3 = new JsonObject();
		
		object1.addProperty("name", "홍길동");
		object1.addProperty("age", 20);
		object1.addProperty("address", "부산");
		
		object2.addProperty("name", "이순신");
		object2.addProperty("age", 33);
		object2.addProperty("address", "서울");
		
		object3.addProperty("name", "세종대왕");
		object3.addProperty("age", 59);
		object3.addProperty("address", "세종시");
		
		array1.add(object1);
		array1.add(object2);
		array1.add(object3);
		
		System.out.println(array1);
		
		// 모델링
		Gson gson = new Gson();
		for (int i = 0; i < array1.size(); i++) {
			Person person = gson.fromJson(array1.get(i), Person.class);
			System.out.println(person);
		}
	}
}
