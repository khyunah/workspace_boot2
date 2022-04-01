package myproject1_todo_list;

import java.util.Scanner;

public class TodoMainTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		TodoClient client = new TodoClient();
		TodoMySql mySql = new TodoMySql();

		String userInputTodo = "";
		String userInputTodoTime = "";
		String menuChoice = "";

		final String CREATE = "1";
		final String READ = "2";
		final String UPDATE = "3";
		final String CHECK = "4";
		final String DELETE = "5";
		final String CLOSE = "0";
		boolean exit = true;
		
		do {
			System.out.println("                          [ 메뉴 선택 ]                            \n");
			System.out.println("   1. 입력   2. 조회   3. 수정   4. 체크하기   5. 삭제   0. 종료    \n");
			menuChoice = scanner.nextLine();

			/**
			 * to do list에 할일을 추가.
			 * 
			 */
			if (menuChoice.equals(CREATE)) {
				System.out.println("                          [ 할일 입력 ]                            \n");
				System.out.println("TO DO : ");
				userInputTodo = scanner.nextLine();
				System.out.println("TO DO TIME : ");
				userInputTodoTime = scanner.nextLine();
				// todo 객체 생성
				TodoDto dto = client.userInputTodo(userInputTodo, userInputTodoTime);
				// todoList에 추가
				mySql.createTodo(dto);
			}

			/**
			 * to do list에 있는 목록을 조회 1. 전체 목록 조회 2. 체크한 목록 조회 3. 체크안한 목록 조회
			 */
			else if (menuChoice.equals(READ)) {
				final String READ_ALL = "1";
				final String READ_CHECKED = "2";
				final String READ_NO_CHECK = "3";
				final String TODO_SEARCH = "4";
				System.out.println("\n\n                          [ 조회 선택 ]                            \n\n");
				System.out.println("         1. 전체 목록 조회              2. 체크한 목록 조회          \n");
				System.out.println("         3. 체크안한 목록 조회          4. 할일 검색                 \n");
				menuChoice = scanner.nextLine();
				if (menuChoice.equals(READ_ALL)) {
					mySql.readAllTodo();
				} else if (menuChoice.equals(READ_CHECKED)) {
					mySql.readCheckedTodo();
				} else if (menuChoice.equals(READ_NO_CHECK)) {
					mySql.readNoCheckTodo();
				} else if (menuChoice.equals(TODO_SEARCH)) {
					System.out.println("\n\n                          [ 검색 하기 ]                            \n");
					System.out.println("TO DO : ");
					userInputTodo = TodoMySql.removeBlankString(scanner.nextLine());
					mySql.todoSerch(userInputTodo);
				} else {
					return;
				}
			}

			/**
			 * todo와 todoTime를 수정
			 * 
			 */
			else if (menuChoice.equals(UPDATE)) {
				mySql.readAllTodo();
				System.out.println("\n                          [ 수정 하기 ]                            \n");
				System.out.println("TO DO NUM : ");
				int inputTodoNum = scanner.nextInt();
				scanner.nextLine();
				boolean isOk = false;
				for (int i = 0; i < mySql.todoList.size(); i++) {
					if (inputTodoNum == mySql.todoList.get(i).getTodoId()) {
						isOk = true;
						System.out.println("UPDATE TO DO : ");
						userInputTodo = scanner.nextLine();
						System.out.println("UPDATE TO DO TIME : ");
						userInputTodoTime = scanner.nextLine();
						TodoDto dto = new TodoDto(userInputTodo, userInputTodoTime);
						mySql.updateTodo(i, dto);
					}
				}
				if (isOk == false) {
					System.out.println("\n\n                          [ 수정 불가 ]                            \n\n");
				}
			}

			/**
			 * 등록한 할일을 체크
			 */
			else if (menuChoice.equals(CHECK)) {
				mySql.readAllTodo();
				System.out.println("                         [ 체크 하기 ]                            \n");
				System.out.println("TO DO NUM : ");
				int inputTodoNum = scanner.nextInt();
				scanner.nextLine();
				mySql.checkTodo(inputTodoNum);
			}

			/**
			 * to do 삭제
			 */
			else if (menuChoice.equals(DELETE)) {
				mySql.readAllTodo();
				System.out.println("                          [ 삭제 하기 ]                            \n");
				System.out.println("TO DO NUM : ");
				int inputTodoNum = scanner.nextInt();
				scanner.nextLine();
				// to do list에 저장된 todo의 id를 넘겨줌
				mySql.deleteTodo(inputTodoNum);
			}

			/**
			 * 프로그램 종료
			 */
			else if (menuChoice.equals(CLOSE)) {
				exit = false;
			} else {
				return;
			}

		} while (exit);
		scanner.close();
	}

}
