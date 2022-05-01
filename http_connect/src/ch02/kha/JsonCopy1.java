package ch02.kha;

import com.google.gson.JsonObject;

public class JsonCopy1 {

	public static void main(String[] args) {
		JsonObject jsonObject1 = new JsonObject();

		jsonObject1.addProperty("name", "홍길동");
		jsonObject1.addProperty("age", 20);
		jsonObject1.addProperty("address", "부산");

		// 1. 얕은 복사 ㅡ> 같은 힙메모리 주소를 참조한다.
//		JsonObject jsonObjectCopy1 = jsonObject1;
//		jsonObjectCopy1.addProperty("job", "student");
//		
//		System.out.println("원본 : " + jsonObject1);
//		System.out.println("복사본 : " + jsonObjectCopy1);
		
		// 2. 깊은 복사 ㅡ> 힙 메모리에 새로 주소값을 생성
		JsonObject jsonObjectCopy1 = jsonObject1.deepCopy();
		jsonObjectCopy1.addProperty("job", "student");
		
		System.out.println("원본 : " + jsonObject1);
		System.out.println("복사본 : " + jsonObjectCopy1);
	}
}
