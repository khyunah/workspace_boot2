package ch02;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Test;

public class MainTest1 {

	public static void main(String[] args) {

		// JSon을 받는 것을 확인 해보았고 ( 응답 )

		// JSon형식으로 요청을 할수도 있음 ( 요청 )
		// 서버에서 알아들을 수 있는 형식으로 요청을 해야 응답을 해줄수 있기때문에 JSon문법으로 보내야 한다.

		// 자바에서 제이슨 문법을 만드는 방법
		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("이름", "홍길동");
		jsonObject1.addProperty("나이", 20);
		jsonObject1.addProperty("직업", "ceo");
		jsonObject1.addProperty("취미", "노래");
		jsonObject1.addProperty("결혼여부", false);

		// 전체
		System.out.println(jsonObject1);
		// 값을 꺼내기
		System.out.println(jsonObject1.get("이름"));
		System.out.println(jsonObject1.get("나이"));
		System.out.println(jsonObject1.get("직업"));
		System.out.println(jsonObject1.get("취미"));
		System.out.println(jsonObject1.get("결혼여부"));
		// 키값이 없으면 null
		System.out.println(jsonObject1.get("주소"));

		// 깊은 복사와 얕은 복사의 개념 이해해보기 ( 자바문법 )
		// 1. 얕은 복사 ( 레퍼런스를 전달 )
		JsonObject b = jsonObject1;
		b.addProperty("안녕", "hi");
		System.out.println(jsonObject1);

		// 2. 깊은 복사 ( 힙메모리에 하나를 더 생성 하는 것 ) ㅡ> 참조하는 곳이 다르기 때문에 복사의 원본에 영향 X
		JsonObject c = jsonObject1.deepCopy();
		c.addProperty("test", 1234);
		System.out.println(jsonObject1);
		System.out.println(c);

		// 배열(리스트)을 이용해서 오브젝트를 넣어줄 수 있다.
		JsonArray array1 = new JsonArray();
		array1.add(b);
		array1.add(c);
		System.out.println(array1);

		// 배열의 값 꺼내기
		System.out.println(array1.get(0));
		System.out.println(array1.get(1));

		System.out.println("------------------------------");
		// 자바 형식으로 모델링 ( 자바에서 키값의 밸류를 사용 하기 위함 )
		// 편리하게 Gson을 이용
		Gson gson = new Gson();
		// 하나의 오브젝트
		Test test = gson.fromJson(array1.get(0), Test.class);
		Test test2 = gson.fromJson(array1.get(1), Test.class);
//		System.out.println(test.get나이());
		System.out.println(test);
		System.out.println(test2);

		// { arr : [ {}, {} ] } 형식으로 만들기
		// 오브젝트 안에 리스트로 오브젝트 넣기
		// 1. 오브젝트 만들기
		JsonObject j1 = new JsonObject();

		// 2. 배열 만들기
		JsonArray a1 = new JsonArray();

		// 3. 리스트에 넣을 오브젝트 만들기
		JsonObject t1 = new JsonObject();
		t1.addProperty("name", "홍길동");
		t1.addProperty("age", 10);

		JsonObject t2 = new JsonObject();
		t2.addProperty("name", "이순신");
		t2.addProperty("age", 20);

		// 4. 배열에 오브젝트 넣어주기
		a1.add(t1);
		a1.add(t2);

		// 5. 오브젝트에 배열 넣어주기
		j1.add("arr", a1);
		System.out.println(j1);
	}
}
