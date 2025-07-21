package com.yedam.app;

import java.util.ArrayList;
import java.util.Scanner;

//사용자 입력 -> DB반영.
//DB결과 -> 콘솔출력.
//컨트롤 역할.
public class main {
	public static void main(String[] args) {
		boolean run = true; // 반복조건에 사용.
		Scanner scn = new Scanner(System.in);
		BookDAO dao = new BookDAO(); //조회.
		while(run) {
			System.out.println("도서 관리 시스템");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("3. 도서수정");
			System.out.println("4. 도서삭제");
			System.out.println("9. 종료");
			System.out.print("선택: ");
			int menu = scn.nextInt(); //입력값을 menu 변수에 대입(할당)
			switch(menu) {
			case 1: //도서목록.
				ArrayList<Book> list = dao.findAll(); // 반환: ArrayList<Book>
				System.out.println("도서번호 도서명      저자      가격");
				System.out.println("==============================");
				for(int i= 0; i<list.size(); i++) {
					System.out.println(list.get(i).getId()
							+" "+list.get(i).getTitle()
					        +" "+list.get(i).getAuthor()
					        +" "+list.get(i).getPrice()
					        );
				}; //for end
				break;
			case 2: //도서등록.
				System.err.println("도서번호>>");
				int bno = scn.nextInt();scn.nextLine(); // 1003 엔터를 치면 사용자가 입력한 숫자 1003만 할당을 하고 엔터를 친 거를 다음 nextLine 도서제목으로 감 반환값 int
				System.out.println("도서제목>>");
				String title = scn.nextLine(); //반환값 String
				System.out.println("도서저자>>");
				String author = scn.nextLine(); //반환값 String
				System.out.println("도서가격>>");
				int price = scn.nextInt();scn.nextLine(); //반환값 int
				
				Book book = new Book(bno, title, author, price);
				if (dao.insert(book)) {
					System.out.println("정상 등록.");
				} else {
					System.out.println("등록 중 오류.");
				}
				break;
				
			case 3: //수정
			System.out.println("도서번호>> ");
			bno = scn.nextInt();scn.nextLine();
			System.out.println("도서가격>> ");
			price = scn.nextInt(); scn.nextLine();
			
			if (dao.update(bno, price))
				System.out.println("정상 ");
			break;
				
			case 9: // 종료
				run = false;
			}// end of switch.
		}//while end
		System.out.println("end of program.");
	}//end of main().

}//class end
