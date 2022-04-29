package ch03;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 파싱하는 방법<br>
 * 1. 단일 오브젝트<br>
 * 2. 배열<br>
 * 3. ArrayList<br>
 * 
 * @author ITPS
 *
 */
public class MainTest4 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		Student[] students = new Student[3];
		/**
		 * 자바에서 사용하는 오브젝트를 JSon문자열로 변환하기
		 */
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 20, "서울");
		Student student3 = new Student("세종대왕", 20, "세종시");

		// 파싱 2
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;

		String studentArr = gson.toJson(students);
		System.out.println(studentArr);

		// Object를 형식이 있는 문자열(json)로 바꾸기
		String jsonStrArr = gson.toJson(student1);
//		System.out.println(jsonStr);

		// ArrayList<Object>를 jsonArray[Object]로
		ArrayList<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
//		System.out.println(list);
		String jsonArrayStr = gson.toJson(list);
		System.out.println(jsonArrayStr);

		/**
		 * 서버측에 데이터를 보낼때 서버가 이해할 수 있는 문자열(json)로 보내기 위해 필요한 개념 <br>
		 */
//		System.out.println("--------------------여기까지-----------------------");

		/**
		 * 서버에서 JSon문자열을 던져준다면 우리가 java를 사용하기 위해서 class(오브젝트)로 변환해야 한다.<br>
		 * ㅡ> DTO
		 */

		System.out.println(jsonStrArr);

		// 파싱하는 방법 1
//		Student objS1 = gson.fromJson(jsonStrArr, Student.class); // ㅡ> 리플렉션 기법
//		System.out.println(objS1.name);
//		System.out.println(objS1.age);
//		System.out.println(objS1.address);

		// 파싱하는 방법 2 배열
//		Student[] objA1 = gson.fromJson(studentArr, Student[].class);
//		for (Student student : objA1) {
//			System.out.println(student);
//		}
//		System.out.println(objA1);

		// 파싱하는 방법 3 ArrayList
		// java.lang.reflect.Type / com.google.gson.reflect.TypeToken( 얘는 노가다를 줄여줌 )
		Type studentType = new TypeToken<ArrayList<Student>>() {
		}.getType(); // ㅡ> 타입 명시함

		ArrayList<Student> arrayList = gson.fromJson(jsonArrayStr, studentType);
		for (Student student : arrayList) {
			System.out.println(student);
		}
	}
}
