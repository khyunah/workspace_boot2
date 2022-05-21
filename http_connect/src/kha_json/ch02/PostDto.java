package kha_json.ch02;

import lombok.Data;
import lombok.ToString;

/**
 * "userId": 1, 
 * "id": 1, 
 * "title": "sunt aut facere repellat provident occaecati
 * 			excepturi optio reprehenderit", 
 * "body": "quia et suscipit\nsuscipit
 * 			recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas
 * 			totam\nnostrum rerum est autem sunt rem eveniet architecto"
 * 
 * @author UserK
 *
 */
@Data
@ToString
public class PostDto {
	public int userId;
	public int id;
	public String title;
	public String body;
}
