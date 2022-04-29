package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoListDto {
	private String id;
	private String title;
	private boolean complete;
}
