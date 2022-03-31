package ch11;

public interface BookService {

	// Book 객체를 저장하는 기능
	void addBook(Book book);

	// Book 객체를 수정하는 기능 ( ArrayList의 인덱스에 접근해서 객체 교체 )
	// 책의 이름으로 검색해서 그 책 수정
	void updateBook(String title, Book book);

	// Book 객체를 삭제하는 기능
	void deleteBook(String title);

	// 책 한건의 정보를 출력하는 기능
	void selectedByTitleBook(String title);

	// ArrayList에 저장되어 있는 책 정보를 전부 출력하는 기능
	void showAllBook();

}
