package tenco.com.data_structure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

// Map
public class DataStructureTest2 {

	public static void main(String[] args) {
		// key와 value구조로 데이터를 저장한다.
		// key는 중복되면 안됨. 대소문자를 구분한다.
		// 인덱스가 없다.
		Map map;

		// null값을 허용한다.
		HashMap<String, String> map1 = new HashMap<>();

		// null값을 허용하지 않는다. null이라는 값에서 세이프팅하다.
		Hashtable<String, String> map2 = new Hashtable<>();

		// 값 입력
		map1.put("A01", "김포공항정문");
		map1.put("A02", "김포공항후문");
		map1.put("A03", "김포공항로비");
		map1.put("B01", "인천공항정문");
		map1.put("B02", "인천공항후문");
		map1.put("B03", "인천공항로비");
		map1.put("C01", null);
		System.out.println(map1);

		// 값 출력
		map1.get("A03");
		System.out.println(map1.get("A03"));
		System.out.println(map1.get("C01"));

		// 값 삭제
		map1.remove("C01");

		// 값 전체 삭제
//		map1.clear();

		// 사이즈 확인 방법
		System.out.println(map1.size());

		// map 계열에서 for문을 사용하는 방법
		
		// 방법 1.
		// java.utill.Map.Entry
		for (Entry<String, String> entry : map1.entrySet()) {
			System.out.println("Key : " + entry.getKey());
			System.out.println("Value : " + entry.getValue());
		}
		System.out.println();
		
		// 방법 2.
		// keySet() ㅡ> Map계열의 메서드 
		for(String key : map1.keySet()) {	// key에는 키값이 담기고 출력해보면 key값이 출력된다.
			System.out.println("key : " + key);
			System.out.println("value : " + map1.get(key));	// get(key)를 하게되면 key값에 해당하는 value를 가져온다.
		}
	}
}
