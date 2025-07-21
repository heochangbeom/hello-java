package 허창범;

import java.util.Scanner;

public class Report5 {

	public static void main(String[] args) {
		// 섭씨 화씨 계산 
		Scanner sc  = new Scanner(System.in);
		boolean run = true;
        
		Label : while(run) {
			System.out.println("--------------------");
			System.out.println("1.섭씨|2.화씨|3.종료");
			System.out.println("--------------------");
			
			System.out.print("선택 >");
			int num = Integer.parseInt(sc.nextLine());

        switch(num) {
        
        case 1:
        	System.out.println("섭씨 온도를 입력해주십시오");
        	double C = Double.parseDouble(sc.nextLine());
        	double F = (double) 9/5* C + 32;
        	System.out.printf("화씨온도는 %f입니다\n", F);
        	System.out.printf("종료\n");
        	continue;
        	
        case 2:
        	System.out.println("화씨 온도를 입력해주십시오");
        	double F1 = Double.parseDouble(sc.nextLine());
        	double C1 = (double) 5/9* (F1 - 32);
        	System.out.printf("섭씨온도는 %f입니다\n", C1);
        	System.out.print("종료");
        	continue;
        	
        default :
        	System.out.print("프로그램 종료");
        	break Label;
        }
        
		}
		
        sc.close();
	}//end main

}
