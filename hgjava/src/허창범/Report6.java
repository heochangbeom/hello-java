package 허창범;

import java.util.Scanner;

public class Report6 {

	public static void main(String[] args) {
		// 가위바위보
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			int human = Integer.parseInt(sc.nextLine());
			int com = (int) (Math.random() *3) ;
		
		if (human != com) {
			if((human+1)%3 == com%3) {
				System.out.printf("나: %d, 컴 : %d, 결과: 패배!", human, com);
			}
			if((human+2)%3 == com%3) {
				System.out.printf("나: %d, 컴 : %d, 결과: 승리!", human, com);
			}
			
		}else {
			System.out.printf("나: %d, 컴: %d 무승부!", human, com);
		}
		
		}
		
		
        sc.close();
	}//end main

}
