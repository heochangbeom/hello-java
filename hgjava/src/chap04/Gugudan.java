package chap04;

public class Gugudan {

	public static void main(String[] args) {
		//구구단
		//단 반복
//		for(int dan = 2; dan<=9; dan++) {
//			System.out.println("**** " + dan + "단 ****");
//			for(int gop = 1; gop<=9; gop++) {
//				System.out.printf("%d X %d = %d\n", dan, gop, dan * gop);
//			}
//		}
		
		
		// 한 단의 구구단2
//		for (int ddan = 2; ddan<=9; ddan++) {
//			System.out.printf("  %d단  ", ddan);
//		}
//		for(int gop = 1; gop<=9; gop++) {
//			System.out.println();
//			for(int dan = 2; dan<=9; dan++) {
//				System.out.printf("%dX%d=%2d ", dan, gop, dan * gop);
//			}
//		}
		
		//별찍기
//		for(int i = 1; i<=4; i++) {
//			for(int star = 1; star<=i; star++) {
//				System.out.print("*");
//			}
//			System.out.println();
//			
//		}
		
		//별찍기2
		for(int i = 3; i>=0; i--) {
			for(int j = 1; j>=i; j--) {
			System.out.print(" ");
			}
			for(int star = 1; star<=4; star++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		
	}//end main

}
