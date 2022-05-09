package ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShopDto {
	String uUserName;
	String uBirthYear;
	String uAddr;
	String uMobile;
	String bUserName;
	String bprodName;
	String bPrice;
	String bAmount;
}
