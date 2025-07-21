package 허창범;

import java.util.Scanner;

public class Report2 {

	public static void main(String[] args) {
		// 2 동전 교환
        Scanner sc = new Scanner(System.in);
      		System.out.println("금액을 입력하라!");
      		int money = Integer.parseInt(sc.nextLine());
      		
      		int fmnum = 0;
      		int omnum = 0;
      		int ftnum = 0;
      		int otnum = 0;
      		int remain = 0;
      	
      		
      		fmnum = money/500;
      		remain = money%500;
      		
      		omnum = remain/100;
      		remain = remain%100;
      		
      		ftnum = remain/50;
      		remain = remain%50;
      		
      		ftnum = remain/10;
      		remain = remain%10;
      		
      		System.out.printf("500원: %d개\n100원: %d개\n50원: %d개\n10원: %d개\n남은 금액: %d원", fmnum, omnum, ftnum, otnum, remain);
      		
      		sc.close();
		
	}//end main

}
