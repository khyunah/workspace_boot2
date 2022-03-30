package ch05;

// 인터페이스 타입으로 다형성 구현 가능 
import java.util.Scanner;

public class UserInfoClient {

	public static final String MYSQL = "mysql";
	public static final String ORACLE = "oracle";

	public static void main(String[] args) {

		// 사용자한테 UserInfo 정보를 받는다.
		UserInfo info = new UserInfo("abc123","aa111222","홍길동");
//		info.setUserId("abc123");
//		info.setPassword("aa111222");
//		info.setUserName("홍길동");

		// 인터페이스 활용

		// 1.
//		UserInfoMySqlDao mySqlDao = new UserInfoMySqlDao();
//		mySqlDao.insertUserInfo(info);
//
//		// 2.
//		UserInfoOracleDao oracleDao = new UserInfoOracleDao();
//		oracleDao.insertUserInfo(info);

		// 문자열 비교 할때는 equals라는 것을 사용
		// equals는 문자열의 값을 비교
		// == 는 주소값을 비교

		String str = new String("mysql");
//		if (str == MYSQL) {

//		if ("mysql".equals(MYSQL)) {
//			System.out.println("문자열이 같습니다.");
//		} else {
//			System.out.println("문자열이 다릅니다.");
//		}

		// 문제 1. mysql 문자열이면 ㅡ> userInfoMysqlDao동작
		// oracle 문자열이면 ㅡ> userInfoOracleDao동작

		Scanner scanner = new Scanner(System.in);

		System.out.println("사용할 DB를 입력해주세요.");
		String userInput = scanner.nextLine();
		UserInfoDao userInfoDao = null;
		if (userInput.equals(MYSQL)) {
			userInfoDao = new UserInfoMySqlDao();
		} else if (userInput.equals(ORACLE)) {
			userInfoDao = new UserInfoOracleDao();
		} else {
			System.out.println("동작 할수 없습니다.");
		}
		scanner.close();

		if (userInfoDao != null) {
			userInfoDao.insertUserInfo(info);
		}
	}
}
