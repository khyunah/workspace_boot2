package ch02.kha;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonArray1 {

	public static void main(String[] args) {
		// 1. JSon 객체를 생성
		JsonObject jsonObject1 = new JsonObject();
		JsonObject jsonObject2 = new JsonObject();

		// 2. addProperty() 를 이용하여 값을 추가한다.
		jsonObject1.addProperty("name", "홍길동");
		jsonObject1.addProperty("age", 20);
		jsonObject1.addProperty("address", "부산");

		jsonObject2.addProperty("name", "김길동");
		jsonObject2.addProperty("age", 10);
		jsonObject2.addProperty("address", "서울");

		// 3. JSon 배열을 생성
		JsonArray jsonArray1 = new JsonArray();
		jsonArray1.add(jsonObject1);
		jsonArray1.add(jsonObject2);
		
		// 배열 확인 
		System.out.println(jsonArray1);
		System.out.println(jsonArray1.get(0));
		System.out.println(jsonArray1.get(1));
		
		// 하나의 배열을 다시 오브젝트로 감쌀수 있다.
		JsonObject jsonObjectAll = new JsonObject();
		jsonObjectAll.add("길동이1", jsonArray1);
		jsonObjectAll.add("길동이2", jsonArray1);
		System.out.println(jsonObjectAll);
	}
}
