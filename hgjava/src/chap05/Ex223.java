package chap05;

import java.util.Scanner;

public class Ex223 {

	public static void main(String[] args) {
		// p223 q6
		//switch문 이용
		boolean run = true;
		int stuNum = 0;
		int max = 0;
		int min = 100;
		int avg = 0;
		int[] scores = null;
		int sum = 0;
		Scanner sc =new Scanner(System.in);
		
		while(run) {
			System.out.println();
			System.out.println("----------------------------");
			System.out.println("1.학생|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("----------------------------");
			System.out.println("선택>");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
			case 1:
			    System.out.println("학생수");
			    stuNum = Integer.parseInt(sc.nextLine());
			    scores = new int [stuNum];
			    continue;
			    
			case 2:
				for(int i = 0; i<stuNum; i++) {
					System.out.println("점수입력");
					scores[i] = Integer.parseInt(sc.nextLine());
				}
				continue;
				
			case 3:
				System.out.println("점수리스트");
				for(int i = 0; i<scores.length; i++) {
					System.out.printf("점수 : %d\n", scores[i]);
				}
				continue;
				
			case 4:
				System.out.println("분석");
					for(int score : scores) {
						sum += score;
						if(score > max) {
							max = score;
						}
						}
				avg = sum/scores.length;
				System.out.printf("최고점수 : %d\n", max);
				System.out.printf("평균값 : %d", avg);
				continue;
				
			default :
				System.out.println("종료");
				
				
			}//switch
			
			
		}//while
		

	}//end main

}//class
