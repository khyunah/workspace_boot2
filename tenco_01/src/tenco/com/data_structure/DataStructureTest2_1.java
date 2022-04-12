package tenco.com.data_structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataStructureTest2_1 {

	public static void main(String[] args) {
		// Map 컬렉션 클래스
		Map<String, String> map;
		
		// HashMap
		HashMap<String, String> hashMap1 = new HashMap<>();
		
		// 값 추가
		hashMap1.put("A_01", "A강의장");
		hashMap1.put("B_02", "B강의장");
		hashMap1.put("C_01", "C-1강의장");
		hashMap1.put("C_02", "C-2강의장");
		hashMap1.put("D_01", "D강의장");	// key값이 중복이 되지 않기 때문에
		hashMap1.put("D_01", "D-1강의장");	// 최후 입력으로 변경됨.
		
		// 값 수정
		hashMap1.replace("A_01", "A-1강의장");
		hashMap1.put("B_02", "B-1강의장");

		// 값 삭제 1. key값으로만 삭제 ㅡ> 삭제할 값이 있으면 value값을 리턴해주고, 없으면 null을 리턴한다.
		hashMap1.remove("C_02");
		
		// 값 삭제 2. key와 value 둘다 이용하여 삭제 ㅡ> 삭제할 값이 있으면 true, 없으면 false를 반환한다.
		hashMap1.remove("D_01", "D-1강의장");
		
		// 값 검색 1. containsKey ㅡ> 값이 있으면 true, 없으면 false를 반환한다.
		hashMap1.containsKey("B_02");
		
		// 값 검색 2. containsValue ㅡ> 값이 있으면 true, 없으면 false를 반환한다.
		hashMap1.containsValue("D-1강의장");
		
		// 값 조회
		// 1. Entry로 key와 value를 한 셋트로 묶어와야 for문 가능
		for (Entry<String, String> entry : hashMap1.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		// 2. keySet()이용하기
		for (String key : hashMap1.keySet()) {
			System.out.println(key);				// key값만 담겨있다
			System.out.println(hashMap1.get(key));	// key값으로 해당 value를 리턴해준다.
		}
	}
}
