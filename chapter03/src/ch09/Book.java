package ch09;

public class Book {
	public static int idInstance = 0;
	private int id;
	private String title;
	private String author;

	public Book(String title, String author) {
		this.id += ++idInstance;
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "[ 도서 번호 : " + id + ", 도서명 : " + title + ", 작가 : " + author + " ]";
	}
}
