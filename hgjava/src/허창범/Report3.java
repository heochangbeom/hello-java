package 허창범;

public class Report3 {

	public static void main(String[] args) {
		// 구구단 계산 
		for(int dan= 2; dan<=9; dan++) {
			System.out.printf("   %d단  ", dan);
			
		}
		System.out.println();
		
        for(int i = 1;i<=9; i++) {
        	for(int j= 1; j<=9; j++) {
        		int gop = i*j;
        		System.out.printf(" %dX%d=%2d", j, i, gop);
        	}
        	System.out.println();
        }
		
	}//end main

}
