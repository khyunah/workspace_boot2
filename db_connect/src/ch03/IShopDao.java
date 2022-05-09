package ch03;

import java.util.ArrayList;

public interface IShopDao {

	// usertbl + buytbl 결과 *
	ArrayList<ShopDto> innerJoin1();
	
	// usertbl + buytbl null제거, 결과 *
	ArrayList<ShopDto> leftJoin1();
	
	// buytbl + usertbl 결과 *
	ArrayList<ShopDto> leftJoin2();
	
	// 구매를 한 특정 고객의 정보를 출력하는 기능
	ArrayList<ShopDto> buyInfo(String userName);
	
	// 특정 구매 물품을 구매한 고객의 정보를 출력하는 기능 
	ArrayList<ShopDto> itemInfo(String prodName);
	
	// 특정 가격의 물품을 구매한 사람의 정보를 출력하는 기능 
	ArrayList<ShopDto> priceInfo(String price);
	
}
