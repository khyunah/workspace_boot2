package ch03.kha;

import java.util.ArrayList;

import com.google.gson.Gson;

public class MainTest3 {

	public static void main(String[] args) {
		// 자바 오브젝트 
		Person person1 = new Person("홍길동", 20, "부산");
		Person person2 = new Person("이순신", 33, "서울");
		Person person3 = new Person("세종대왕", 59, "세종시");
		
		// JSon 문자열로 변환
		Gson gson = new Gson();
		String jsonString1 = gson.toJson(person1);
		String jsonString2 = gson.toJson(person2);
		String jsonString3 = gson.toJson(person3);
		
		// 변환 확인
		System.out.println(jsonString1);
		System.out.println(jsonString2);
		System.out.println(jsonString3);
		
		// 자바 오브젝트를 ArrayList에 담기
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		
		System.out.println(persons);
		
		// 자바 오브젝트를 담은 ArrayList를 JSon 문자열로 변환
		String jsonStringArray = gson.toJson(persons);
		System.out.println(jsonStringArray);
	}
}
