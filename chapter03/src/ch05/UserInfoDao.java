package ch05;

// 데이터를 담아두기만 하는 DAO
public interface UserInfoDao {

	void insertUserInfo(UserInfo info);
	void updateUserInfo(UserInfo info);
	void deleteUserInfo(String userId);
}
