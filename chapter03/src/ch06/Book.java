package ch06;

public class Book {

	private int bookId;
	private String title;

	public Book(int bookId, String title) {
		this.bookId = bookId;
		this.title = title;
	}
	
	public boolean idSameBook(Book book) {
		if(book.title.equals(this.title)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + "]";
	}

	// Book이라는 클래스에 title이 같은 녀석이면 같은 객체다 라고 재정의 했음
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			// 북이라는 클래스 타입이 들어오면 안에 접근해서 title 확인
			Book tempBook = (Book) obj;
			String title = tempBook.title;
			System.out.println(title);
			if (this.title == title) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
