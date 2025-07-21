package chap06_01;

import java.util.Scanner;

public class BookData {
	//책 데이터 생성
		//필드
		//생성자 : 기본생성자 => 컴파일 자동 생성
		//메소드
	    Scanner sc = new Scanner(System.in);
	    
		Book[] bkData(int n) {
			
		Book[] books = new Book[n];
		for(int i = 0; i<n;i++) {
			System.out.printf("%d번재 도서 정보 입력\n", i+1);
			System.out.print("도서 번호 >");
			int bknum = Integer.parseInt(sc.nextLine());
			System.out.print("도서 제목 >");
			String bkname = sc.nextLine();
			System.out.print("도서 가격 >");
			int bkprice = Integer.parseInt(sc.nextLine());
			
			books[i]= new Book(bknum,bkname,bkprice);
			
		}
		return books;
		
		};
	

}
