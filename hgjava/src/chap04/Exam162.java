package chap04;

import java.util.Scanner;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 게임
		// 주사위를 2개 던져서 
		// 합이 10을 넘으면 두수를 더하고   > 덧셈결과 : 000
		// 아니면 두 수를 곱한 결과를 출력   > 곱셈결과 : 000
		
		int num  = (int) (Math.random() * 6) +1;
		int num1 = (int) (Math.random() * 6) +1;
		
		if (num + num1 >10) {
			int hap = num + num1;
			System.out.printf("%d + %d = %d \n", num, num1, hap);
		} else {
			int gop = num * num1;
			System.out.printf("%d * %d = %d \n", num, num1, gop);
		}
		
		
		//오전시간(9~12) 일정 출력
		//현재 시간 확인
		int time = (int) (Math.random() * 4) +9;
		System.out.println("현재시간 : " + time);
		
		switch(time) {
		case 9 :
			System.out.println("출근합니다");
		case 10:
			System.out.println("회의합니다");
		case 11:	
			System.out.println("업무를 봅니다");
		case 12:	
			System.out.println("외근을 나갑니다");
		}
		System.out.println("오늘 일정 끝");
		
		
		//169  문제3 ==> switch
//		Scanner sc = new Scanner(System.in);
//		System.out.println("점수를 입력해주십시오.");
//		int score  = Integer.parseInt(sc.nextLine());
//		switch (score/10) {
//		case 6:
//			System.out.println("D입니다");
//			break;
//		case 7:
//			System.out.println("C입니다");
//			break;
//		case 8:
//			System.out.println("B입니다");
//			break;
//		case 9:
//			System.out.println("A입니다");
//			break;
//		case 10:
//			System.out.println("A입니다");
//			break;
//		default :
//			System.out.println("바보입니다");
//		}
		
		// 주사위 게임
		// 주사위 2개를 던져서 합이 10이 되면 탈출
		 //주사위 순서쌍 출력 (5, 2)
		// 5회이상이 되면 게임 오버 출력
		for (int i = 1; i<=5; i++) {
			int dice1 = (int)(Math.random() * 6) +1;
			int dice2 = (int)(Math.random() * 6) +1;
			int h = dice1 + dice2;
			System.out.printf("(%d, %d) = %d \n", dice1, dice2, h);
			if(h > 10) {
				i = 6;
				System.out.println("탈출 성공");
				break;
			}
			
		}
		System.out.println("게임 오버");
		
		//반복문
		int i = 0;
		for(i = 1; i<=5; i++) {
			System.out.println(" i = " + i);
		}
		System.out.println("탈출 1 ~ " + (i + 1) + "까지");
		
		
		for(int = 1; i<=9; i++) {
			System.out.println();
		}
	}//end
	
	

}
