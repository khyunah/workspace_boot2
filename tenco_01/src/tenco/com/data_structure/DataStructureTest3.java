package tenco.com.data_structure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DataStructureTest3 {

	public static void main(String[] args) {
		Set set;
		// 중복이 안되고 순서가 없다.
		HashSet<Integer> set1 = new HashSet<>();

		// 값 추가
		set1.add(1);
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(3);
		set1.add(3);
		set1.add(3);
		set1.add(4);

		// 중복된 값 들어갔는지 사이즈 확인
		System.out.println(set1.size());

		// 값 삭제
		set1.remove(1);
		System.out.println(set1);

		// 전체삭제
//		set1.clear();

		// while문 사용
		Iterator<Integer> iter = set1.iterator();
		while (iter.hasNext()) {
			System.out.println("값 확인 : " + iter.next());
		}

		System.out.println();

		HashSet<Integer> set2 = new HashSet<>();
//		set2.add(getRandom());
//		set2.add(getRandom());
//		set2.add(getRandom());
//		set2.add(getRandom());
//		set2.add(getRandom());
//		set2.add(getRandom());
//		System.out.println(set2);

		boolean flag = true;
		while (flag) {
			set2.add(getRandom());
			if (set2.size() == 6) {
				flag = false;
				System.out.println(set2);
			}
		}
	}

	public static int getRandom() {
		Random random = new Random();
		int value = random.nextInt(45) + 1;
		return value;
	}
}
