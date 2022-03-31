package ch11;
// 삭제하고 나서 중간에 null 없이 앞으로 땡겨주기 수정해야함
import java.util.Scanner;

public class BookArrayMainTest {

	public static void main(String[] args) {

		BookArray bookArray = new BookArray();
		BookClient bookClient = new BookClient();
		Book book;
		Scanner scanner = new Scanner(System.in);
		String menuChoice = "";
		String title = "";
		String author = "";
		boolean exit = true;

		do {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 생성 2. 수정 3. 제목 조회 4. 전체 조회 5. 삭제 0. 프로그램 종료");
			menuChoice = scanner.nextLine();
			if (menuChoice.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				exit = false;
			} else if (menuChoice.equals("1")) {
				System.out.println("책을 생성합니다.");
				System.out.println("도서명 : ");
				title = scanner.nextLine();
				System.out.println("작가 : ");
				author = scanner.nextLine();
				book = bookClient.createBook(title, author);
				bookArray.addBook(book);
			} else if (menuChoice.equals("2")) {
				System.out.println("수정할 책의 제목을 입력해 주세요.");
				String savedTitle = scanner.nextLine();
				boolean updateCheck = false;
				for (int i = 0; i < bookArray.books.length; i++) {
					if (savedTitle.equals(bookArray.books[i].getTitle())) {
						System.out.println("수정할 정보를 입력해 주세요.");
						System.out.println("도서명 : ");
						title = scanner.nextLine();
						System.out.println("작가 : ");
						author = scanner.nextLine();
						Book updatebook = new Book(0, title, author);
						bookArray.updateBook(savedTitle, updatebook);
						updateCheck = true;
						if(updateCheck == true) break;
					}
				}
			} else if (menuChoice.equals("3")) {
				System.out.println("조회할 도서명을 입력해주세요.");
				title = scanner.nextLine();
				bookArray.selectedByTitleBook(title);
			} else if(menuChoice.equals("4")) {
				System.out.println("등록된 도서 목록을 전체 조회합니다.");
				bookArray.showAllBook();
			} else if(menuChoice.equals("5")) {
				System.out.println("삭제할 도서명을 입력해주세요.");
				title = scanner.nextLine();
				bookArray.deleteBook(title);
			}
		} while (exit);
	}

}
