package ch09;

public interface BookDao {
	
	// 저장하는 메서드
	void insertBook(Book book);
	
	// 수정하는 메서드
	void updateBook(int index, Book book);
	
	// 삭제하는 메서드
	void deleteBook(int index);
	
	// 출력하는 메서드
	void readAllBook();
	void readBook(Book book);

}
