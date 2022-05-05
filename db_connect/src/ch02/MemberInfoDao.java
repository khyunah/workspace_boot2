package ch02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberInfoDao implements IMemberInfoDao {

	private static final String TABLE_NAME = "membertbl";
	// DBClient 를 통해서 DB접속 처리 하기
	private DBClient dbClient;
	private Connection conn;

	public MemberInfoDao() {
		dbClient = DBClient.getInstance();
		conn = dbClient.getConnection();
	}

	@Override
	public synchronized ArrayList<MemberDto> select() {

		ArrayList<MemberDto> dataResult = new ArrayList<>();

		String sqlFormat;
		String sql;

		sqlFormat = "SELECT * FROM %s";
		sql = String.format(sqlFormat, TABLE_NAME);

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// 하나의 로우가 하나의 객체가 됨.
				MemberDto dto = new MemberDto();
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberAddress(rs.getString("memberAddress"));

				dataResult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dataResult;
	}

	@Override
	public synchronized int insert(MemberDto dto) {
		String sqlFormat = "INSERT INTO %s VALUES('%s', '%s', '%s')";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberId(), dto.getMemberName(),
				dto.getMemberAddress());

		Statement stmt = null;
		int result = 0;

		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println("result 행 (레코드) 갯수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public synchronized int update(MemberDto dto) {
		// 해당 레코드 존재여부를 먼저 검사하는 것이 일반적이다.

		String sqlFormat = "UPDATE %s SET memberName = '%s' WHERE memberId = '%s'";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberName(), dto.getMemberId());
		int result = 0;

		try (Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public synchronized int delete(String memberId) {
		// 딜리트는 값이 없어도 삭제를 성공했다고 반환한다. 
		String sqlFormat = "DELETE FROM %s WHERE memberId = '%s'";
		String sql = String.format(sqlFormat, TABLE_NAME, memberId);
		int result = 0;
		
		try (Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
