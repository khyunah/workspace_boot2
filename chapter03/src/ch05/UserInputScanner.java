package ch05;

import java.util.Scanner;

public class UserInputScanner {
	Scanner scanner = new Scanner(System.in);
	public static final String MYSQL = "mysql";
	public static final String ORACLE = "oracle";
	UserInfo userInfo;
	UserInfoDao userInfoDao;

	// 사용자 정보 입력받아 생성 insert
	public UserInfo insertInput() {
		System.out.println("아이디를 입력하세요.");
		String userInputId = scanner.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		String userInputPw = scanner.nextLine();
		System.out.println("이름을 입력하세요.");
		String userInputName = scanner.nextLine();
		userInfo = new UserInfo(userInputId, userInputPw, userInputName);

		return userInfo;
	}

	// 사용할 DB선택 
	public UserInfoDao selectDB() {
		System.out.println("사용할 DB를 선택하세요");
		System.out.println(" mysql  /  oracle");
		String userInputDB = scanner.nextLine();

		if (userInputDB.equals(MYSQL)) {
			userInfoDao = new UserInfoMySqlDao();
		} else if (userInputDB.equals(ORACLE)) {
			userInfoDao = new UserInfoOracleDao();
		} else {
			System.out.println("동작 할 수 없습니다.");
		}
		return userInfoDao;
	}
}
