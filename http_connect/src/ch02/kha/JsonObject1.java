package ch02.kha;

import com.google.gson.JsonObject;

public class JsonObject1 {

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
		
		// JSon 문법 확인
		System.out.println(jsonObject1);
		System.out.println(jsonObject2);
		
		// 값을 하나씩 꺼내올떄
		System.out.println("값이 있을때 : " + jsonObject1.get("name"));
		System.out.println("값이 없을때 : " + jsonObject1.get("hobby"));
		
	}
}
