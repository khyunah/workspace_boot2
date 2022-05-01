package ch05;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Yts {

	@SerializedName("status") // 서버에서 보내주는 키값
	@Expose
	private String status;

	@SerializedName("status_message")
	@Expose
	private String statusMessage;

	@SerializedName("data")
	@Expose
	private Data data;
}
