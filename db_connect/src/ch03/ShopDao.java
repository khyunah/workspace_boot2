package ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch02.DBClient;

public class ShopDao implements IShopDao {

	DBClient client;
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public ShopDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
		preparedStatement = null;
		resultSet = null;
	}

	@Override
	public ArrayList<ShopDto> innerJoin1() {
		String selectInnerJoin1 = 
				"SELECT * FROM usertbl AS u INNER JOIN buytbl AS b ON u.userName = b.userName";
		ArrayList<ShopDto> dataresult = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectInnerJoin1);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ShopDto dto = new ShopDto();
				dto.setUUserName(resultSet.getString("u.userName"));
				dto.setUBirthYear(resultSet.getString("birthYear"));
				dto.setUAddr(resultSet.getString("addr"));
				dto.setUMobile(resultSet.getString("mobile"));
				dto.setBUserName(resultSet.getString("b.userName"));
				dto.setBprodName(resultSet.getString("prodName"));
				dto.setBPrice(resultSet.getString("price"));
				dto.setBAmount(resultSet.getString("amount"));
				dataresult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataresult;
	}

	@Override
	public ArrayList<ShopDto> leftJoin1() {
		String selectLeftJoin1 = 
				"SELECT * FROM usertbl AS u LEFT JOIN buytbl AS b ON u.userName = b.userName WHERE b.userName is null";
		ArrayList<ShopDto> dataresult = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectLeftJoin1);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ShopDto dto = new ShopDto();
				dto.setUUserName(resultSet.getString("u.userName"));
				dto.setUBirthYear(resultSet.getString("birthYear"));
				dto.setUAddr(resultSet.getString("addr"));
				dto.setUMobile(resultSet.getString("mobile"));
				dto.setBUserName(resultSet.getString("b.userName"));
				dto.setBprodName(resultSet.getString("prodName"));
				dto.setBPrice(resultSet.getString("price"));
				dto.setBAmount(resultSet.getString("amount"));
				dataresult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataresult;
	}

	@Override
	public ArrayList<ShopDto> leftJoin2() {
		String selectLeftJoin2 =
				"SELECT * FROM buytbl AS b LEFT JOIN usertbl AS u ON b.userName = u.userName";
		ArrayList<ShopDto> dataresult = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectLeftJoin2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ShopDto dto = new ShopDto();
				dto.setUUserName(resultSet.getString("u.userName"));
				dto.setUBirthYear(resultSet.getString("birthYear"));
				dto.setUAddr(resultSet.getString("addr"));
				dto.setUMobile(resultSet.getString("mobile"));
				dto.setBUserName(resultSet.getString("b.userName"));
				dto.setBprodName(resultSet.getString("prodName"));
				dto.setBPrice(resultSet.getString("price"));
				dto.setBAmount(resultSet.getString("amount"));
				dataresult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataresult;
	}
	
	@Override
	public ArrayList<ShopDto> buyInfo(String userName) {
		String selectBuyQuery = "SELECT * \r\n"
				+ "FROM usertbl AS u\r\n"
				+ "inner join buytbl as b\r\n"
				+ "on u.userName = b.userName\r\n"
				+ "where b.userName = ?;";
		
		ArrayList<ShopDto> dataresult = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectBuyQuery);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ShopDto dto = new ShopDto();
				dto.setUUserName(resultSet.getString("u.userName"));
				dto.setUBirthYear(resultSet.getString("birthYear"));
				dto.setUAddr(resultSet.getString("addr"));
				dto.setUMobile(resultSet.getString("mobile"));
				dto.setBUserName(resultSet.getString("b.userName"));
				dto.setBprodName(resultSet.getString("prodName"));
				dto.setBPrice(resultSet.getString("price"));
				dto.setBAmount(resultSet.getString("amount"));
				dataresult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataresult;
	}

	@Override
	public ArrayList<ShopDto> itemInfo(String prodName) {
		String itemQuery = "select * \r\n"
				+ "from usertbl as u\r\n"
				+ "inner join buytbl as b\r\n"
				+ "on u.userName = b.userName\r\n"
				+ "where b.prodName = ? ";
		ArrayList<ShopDto> dataresult = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(itemQuery);
			preparedStatement.setString(1, prodName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ShopDto dto = new ShopDto();
				dto.setUUserName(resultSet.getString("u.userName"));
				dto.setUBirthYear(resultSet.getString("birthYear"));
				dto.setUAddr(resultSet.getString("addr"));
				dto.setUMobile(resultSet.getString("mobile"));
				dto.setBUserName(resultSet.getString("b.userName"));
				dto.setBprodName(resultSet.getString("prodName"));
				dto.setBPrice(resultSet.getString("price"));
				dto.setBAmount(resultSet.getString("amount"));
				dataresult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataresult;
	}

	@Override
	public ArrayList<ShopDto> priceInfo(String price) {
		String priceQuery= "SELECT * \r\n"
				+ "FROM usertbl AS u\r\n"
				+ "INNER JOIN buytbl AS b\r\n"
				+ "ON u.userName = b.userName\r\n"
				+ "WHERE price >= ? ";
		ArrayList<ShopDto> dataresult = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(priceQuery);
			preparedStatement.setString(1, price);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ShopDto dto = new ShopDto();
				dto.setUUserName(resultSet.getString("u.userName"));
				dto.setUBirthYear(resultSet.getString("birthYear"));
				dto.setUAddr(resultSet.getString("addr"));
				dto.setUMobile(resultSet.getString("mobile"));
				dto.setBUserName(resultSet.getString("b.userName"));
				dto.setBprodName(resultSet.getString("prodName"));
				dto.setBPrice(resultSet.getString("price"));
				dto.setBAmount(resultSet.getString("amount"));
				dataresult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataresult;
	}
	public static void main(String[] args) {
		ShopDao dao = new ShopDao();
		
		ArrayList<ShopDto> innerJoin1_Result = dao.innerJoin1();
		System.out.println(innerJoin1_Result);
		ArrayList<ShopDto> leftJoin1_Result = dao.leftJoin1();
		System.out.println(leftJoin1_Result);
		ArrayList<ShopDto> leftJoin2_Result = dao.leftJoin2();
		System.out.println(leftJoin2_Result);
		ArrayList<ShopDto> buyInfo_Result = dao.buyInfo("이순신");
		System.out.println(buyInfo_Result);
		ArrayList<ShopDto> item_Result = dao.itemInfo("책");
		System.out.println(item_Result);
		ArrayList<ShopDto> price_Result = dao.priceInfo("50");
		System.out.println(price_Result);
//		dao.leftJoin1();
//		dao.leftJoin2();
	}

}


