package chap06_01;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookData bkdata = new BookData();
		boolean run = true;
		int bookNum = 0;
		Book[] books = null;
		
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1.도서수 입력|2.도서정보 등력|3.도서정보 전체 조회|4.도서정보 분석}5.종료");
			System.out.println("------------------------------------------------------------");
			
			System.out.print("선택> ");
			int selecNo = Integer.parseInt(sc.nextLine());
			
			switch(selecNo) {
			case 1 :
				System.out.println("도서수> ");
				bookNum = Integer.parseInt(sc.nextLine());
				break;
			
			case 2:
				books = bkdata.bkData(bookNum);
				break;
				
			case 3:
				for(int i = 0; i<bookNum; i++) {
					System.out.printf("도서번호 %d, 도서가격: %d\n",
							books[i].num, books[i].price);
				}
				break;
				
			case 4 :
				int max = books[0].price;
				int min = books[0].price;
				double avg = 0.0;
				for(int i = 0; i < bookNum; i++) {
					if(books[i].price > max) {
						max = books[i].price;
					}
					if(books[i].price < min) {
						min = books[i].price;
					}
				}
				for(int i = 0; i < bookNum; i++) {
					avg += books[i].price;
				}
				avg /= bookNum;
				System.out.println("최고 가격 : " + max + "원");
				System.out.println("최저 가격 : " + min + "원");
				System.out.printf("평균 가격 : %.1f원\n", avg);
				break;
				
			case 5:
			System.out.println("프로그램 종료");
			run = false;
			break;
			
			default:
				System.out.println("다시 선택해주세요");
				break;
			}
		}

	}

}
