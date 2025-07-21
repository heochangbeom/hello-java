package chap04;

import java.util.Scanner;

public class Bank183 {

	public static void main(String[] args) {
		//은행업무
		//잔고변수
		//실행제어 변수
		//업무 1: 예금, 2: 출금: 3:조회, 4:종료
		//종료가 될 때까지 반복
		int balance = 0;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int money;
		
		while(run) {
			System.out.println("--------------------");
			System.out.println("1.예금|2.출금|3.조회|4.종료");
			System.out.println("--------------------");
			
			System.out.print("선택 >");
			int selNum = Integer.parseInt(sc.nextLine());
			
			switch(selNum) {
			case 1:
				System.out.print("예금액을 입력하십시오>>");
				money = Integer.parseInt(sc.nextLine());
				int hap = balance += money;
				System.out.printf("현재잔액은 %d입니다", hap);
				continue;
				
			case 2:
				//출금액이 부족할 경우 잔액부족 출력
				//출금 가능 금출력
				System.out.print("출금액을 입력하십시오>>");
				money = Integer.parseInt(sc.nextLine());
				if ((balance - money) <= 0) {
					System.out.printf("잔액이 부족합니다.\n현재잔액: %d원", balance);
					run = false;
					System.out.println();
				} else {
					System.out.printf("%d원을 출력합니다", money);
					run = false;
					System.out.println();
				}
				continue;
				
			case 3:
				System.out.printf("사랑하는 고객님, 현재잔액은 %d원입니다^^", balance);
				run = false;
				System.out.println();
				continue;
				
			default:
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		

	}//end main

}//main class
