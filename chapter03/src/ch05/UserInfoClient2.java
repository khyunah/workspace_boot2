package ch05;

// 인터페이스 타입으로 다형성 구현 가능 
import java.util.Scanner;

public class UserInfoClient2 {

	public static final String MYSQL = "mysql";
	public static final String ORACLE = "oracle";

	public static void main(String[] args) {

		// 스캐너로 정보 입력 받아 흐름 만들기
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디를 입력하세요.");
		String userInputId = scanner.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		String userInputPw = scanner.nextLine();
		System.out.println("이름을 입력하세요.");
		String userInputName = scanner.nextLine();
		
		UserInfo userInfo = new UserInfo(userInputId, userInputPw, userInputName);

		System.out.println("정보를 저장할 DB를 입력하세요.");
		System.out.println(" mysql  /  oracle");
		String userInputDB = scanner.nextLine();
		UserInfoDao userInfoDao = null;
		if(userInputDB.equals(MYSQL)) {
			userInfoDao = new UserInfoMySqlDao();
		} else if (userInputDB.equals(ORACLE)) {
			userInfoDao = new UserInfoOracleDao();
		} else {
			System.out.println("동작 할 수 없습니다.");
		}
		
		if(userInfoDao != null) {
			userInfoDao.insertUserInfo(userInfo);
			System.out.println("저장 완료");
		}
	}
}
