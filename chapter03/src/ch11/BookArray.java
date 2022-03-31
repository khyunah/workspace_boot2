package ch11;

public class BookArray implements BookService {

	Book[] books = new Book[10];

	/**
	 * 입력받은 책을 생성. 같은 제목으로 책을 생성할 수 없음.
	 */
	@Override
	public void addBook(Book book) {
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				books[i] = book;
				System.out.println("새로운 책을 생성합니다.");
				System.out.println(books[i]);
				return;
			} else if (book.getTitle().equals(books[i].getTitle())) {
				System.out.println("같은 제목의 책을 생성할 수 없습니다.");
			}
		}
		System.out.println("책장이 가득 차 새로운 책을 생성할 수 없습니다.");
	}

	/**
	 * 책의 제목을 입력받아 for문으로 검사를 해서, 책이 있다면 수정.
	 */
	@Override
	public void updateBook(String title, Book book) {
		for (int i = 0; i < books.length; i++) {
			if (title.equals(books[i].getTitle())) {
				books[i].setTitle(book.getTitle());
				books[i].setAuthor(book.getAuthor());
				System.out.println("책을 수정합니다.");
				System.out.println(books[i]);
				return;
			}
		}
		System.out.println("입력하신 제목의 책이 존재 하지 않아 수정할 수 없습니다.");
	}

	/**
	 * 책의 제목을 입력받아 for문으로 검사를 해서, 책이 있다면 삭제.
	 */
	@Override
	public void deleteBook(String title) {
		int index = -1;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (title.equals(books[i].getTitle())) {
					books[i] = null;
					index = i;
					System.out.println("책을 삭제합니다.");
				}
			}
		}
		for (int i = index; i < books.length; i++) {
			books[i] = books[i + 1];
		}
		System.out.println("입력하신 제목의 책이 존재 하지 않아 삭제할 수 없습니다.");
	}

	/**
	 * 책의 제목을 입력받아 for문으로 검사를 해서, 책이 있다면 출력.
	 */
	@Override
	public void selectedByTitleBook(String title) {
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				if (books[i].getTitle().equals(title)) {
					System.out.println(books[i]);
					return;
				}
			}
		}
		System.out.println("입력하신 제목의 책이 존재 하지 않아 검색할 수 없습니다.");
	}

	/**
	 * books안에 null이 아닌 인덱스의 책만 전부 출력
	 */
	@Override
	public void showAllBook() {
		boolean check = false;
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				System.out.println(books[i]);
				check = true;
			}
		}
		if (check == false) {
			System.out.println("책이 존재하지 않습니다.");
		}
	}
}
