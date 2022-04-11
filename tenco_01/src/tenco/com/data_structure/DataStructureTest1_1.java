package tenco.com.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// 컬렉션 프레임워크
public class DataStructureTest1_1 {

	public static void main(String[] args) {
		List list1;
		
		ArrayList<Integer> integers1 = new ArrayList<Integer>();				// 생성만 하기
		ArrayList<Integer> integers2 = new ArrayList<>(Arrays.asList(1,2,3));	// 생성과 초기화 동시에
		
		// 값 추가
		integers2.add(50);
		integers2.add(null);
		
		// 값 수정
		integers2.set(2, 20);
		integers2.add(1, 10);

		// 값 삭제
		integers2.remove(5);
		
		// 값 전체 삭제
//		integers2.clear();

		// 값 검색 1. ㅡ> true, false로 반환
		integers2.contains(20);
		System.out.println(integers2.contains(20));	// 값이 있으면 true, 없으면 false를 반환한다.
		
		// 값 검색 2. ㅡ> 인덱스 번호로 반환
		integers2.indexOf(10);
		
		// 값 출력 1. ㅡ> 인덱스 번호의 값을 출력하기
		integers2.get(1);
		
		// 값 출력 2. ㅡ> for문을 이용하여 전체를 출력하기
		for (Integer integer : integers2) {
			System.out.println(integer);
		}
		
		// 값 출력 3. ㅡ> 반복자를 이용하여 전체를 출력하기
		Iterator<Integer> iter = integers2.iterator();
		while(iter.hasNext()) {						// 값이 있으면 true, 없으면 false
			System.out.println(iter.next());
		}
		
		// 해당 객체가 비었는지 확인
		integers2.isEmpty();
		
		// 해당 객체의 길이
		integers2.size();
		
	}
}
