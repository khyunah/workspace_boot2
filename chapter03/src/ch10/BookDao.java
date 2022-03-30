package ch10;

public interface BookDao {

	// 생성 
	void addBook(Book book);
	
	// 수정
	void updateBook(int index, Book book);
	
	// 삭제
	void removeBook(int index);
	
	// 조회
	void selectBook(int index);
	
	// 전체 조회
	void selectBookAll();
}
