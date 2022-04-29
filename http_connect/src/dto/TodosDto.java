package dto;

import lombok.Data;

@Data
public class TodosDto {
	private int userId;
	private int id;
	private String title;
	private boolean completed;
}
