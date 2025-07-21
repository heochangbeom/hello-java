package 허창범;

import java.util.Scanner;

public class Report1 {

	public static void main(String[] args) {
		// 윤년 계산
        Scanner sc = new Scanner(System.in);
        System.out.println("연도를 입력하라!");
		int num = Integer.parseInt(sc.nextLine());
	
		if(num%4 == 0) {
			if(num%100 != 0) {
				System.out.println("윤년");
			}else if (num%400 == 0){
				System.out.println("윤년");
			}else {
				System.out.println("평년");
			}
		} else {
			System.out.println("평년");
		}
		
		sc.close();
		
	}//end main

}
