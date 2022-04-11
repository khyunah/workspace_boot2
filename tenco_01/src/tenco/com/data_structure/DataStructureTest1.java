package tenco.com.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// 컬렉션 프레임워크
public class DataStructureTest1 {

	public static void main(String[] args) {
		// List ㅡ> 인터페이스라서 생성할수 없다.
		// 중간에 데이터를 추가하거나 삭제가 용이하다.
		List list0 = new ArrayList<>();

		// ArrayList
		// 순서가 있고 중복이 가능하다. null도 값으로 입력된다.
		// 선언 방법
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<>();

		// 선언과 동시에 초기화 ㅡ> Arrays.asList() 를 이용하여 가능
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));

		// 값 추가 방법
		list3.add(4);
		list3.add(null);
		System.out.println(list3);

		// 값 수정
		list3.add(1, 10);
		System.out.println(list3);

		// 값 삭제
		list3.remove(5);
		System.out.println(list3);

		// 전체 삭제
//		list3.clear();
//		System.out.println(list3);

		// 출력 방법
		System.out.println(list3.get(3));

		// 추가적인 메서드 확인

		// 길이
		System.out.println(list3.size());

		// 컬렉션이 비어있는지 확인
		System.out.println(list3.isEmpty());

		// for
		for (Integer i : list3) {
			System.out.println("list3 i : " + i);
		}

		// while
		// Iterator
		// 요소 순회 ( 반복자 ) ㅡ> 컬렉션 프레임 워크에 저장된 요소들을 하나씩 차례로 참조한다.
		Iterator<Integer> iter = list3.iterator();
		while (iter.hasNext()) {// ㅡ> 다음에 값이 있으면 true, 값이 없으면 false
			System.out.println("while : " + iter.next());
		}

		// 검색 ㅡ> 500이라는 값이 있니? 
		System.out.println(list3.contains(500));
		
		// index of ㅡ> 값이 있으면 인덱스번호를 반환, 없으면 -1을 반환
		System.out.println(list3.indexOf(0));
		System.out.println(list3.indexOf(1));
		System.out.println(list3.indexOf(4));
		System.out.println(list3.indexOf(100));
	}
}
