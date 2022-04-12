package tenco.com.data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataStructureTest3_1 {

	public static void main(String[] args) {
		// Set 인터페이스
		Set set;

		// HashSet
		HashSet<Integer> hashSet1 = new HashSet<>();

		// 값 추가
		hashSet1.add(11);
		hashSet1.add(22); // 중복
		hashSet1.add(22); // 중복
		hashSet1.add(33);
		hashSet1.add(44);
		hashSet1.add(55);
		hashSet1.add(66); // 중복
		hashSet1.add(66); // 중복

		// 중복된 값을 추가하고 객체를 찍어보면 중복을 허용하지 않는다.
		System.out.println(hashSet1);
		System.out.println(hashSet1.size());

		// 값 수정은 할수 없음

		// 값 검색 ㅡ> 값을 입력하고, 있으면 true, 없으면 false를 반환.
		hashSet1.contains(33);

		// 값 삭제 ㅡ> 삭제할 값을 입력해준다.
		// 결과는 삭제할 값이 있어서 삭제를 하면 true, 없으면 false를 반환.
		hashSet1.remove(66);
		hashSet1.remove(99);

		// 전체 삭제
//		hashSet1.clear();

		// 객체가 비어있는지 확인
		hashSet1.isEmpty();

		// 객체의 사이즈 확인
		hashSet1.size();

		// 값 조회
		
		// 1. for문 사용 안됨 ㅡ> index가 없기 때문에

		// 2. while문
		Iterator<Integer> iter = hashSet1.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// 3. 오름차순으로 보기
		// Set의 특성상 인덱스가 없기때문에 자체적으로 오름차순으로 정렬할 순 없고,
		// 다른 컬렉션을 빌려와야한다.
		ArrayList<Integer> arrSet = new ArrayList<>(hashSet1);
		Collections.sort(arrSet);
		for (Integer result : arrSet) {
			System.out.println(result);
		}
	}
}
