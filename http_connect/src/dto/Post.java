package dto;

/**
 * 객체를 가지고 올때에 해당 키값의 밸류를 필요로 할때에면<br>
 * 서브스트링으로 하나하나 나눠도 되긴 하겠지만 <br>
 * 하나의 객체로 만들어서 그객체에 키값에 밸류를 넣어주는 것이 더 편하다.
 * 
 */
public class Post {
	public int userId;
	public int id;
	public String title;
	public String body;
}
