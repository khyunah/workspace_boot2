package ch03.kha;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 문제 1

[
	{
		"name": "홍길동",
		"age" : 20, 
		"address" : "부산"
	},
	{
		"name": "이순신",
		"age" : 33, 
		"address" : "서울"
	},
	{
		"name": "세종대왕",
		"age" : 59, 
		"address" : "세종시"
	}
]
 *
 */
public class MainTest1 {

	public static void main(String[] args) {
		
		JsonArray jsonArray = new JsonArray();
		
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
		
		jsonArray.add(object1);
		jsonArray.add(object2);
		jsonArray.add(object3);
		
		System.out.println(jsonArray);
	}
}
