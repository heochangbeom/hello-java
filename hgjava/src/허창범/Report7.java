package 허창범;

public class Report7 {

	public static void main(String[] args) {
		//3, 6, 9 게임
		for(int i = 1; i<=50; i++) {
			int cnt = 0;
			if(i/10 == 3) {
				cnt++;
			}
				if(i % 10 == 3 ||i % 10 == 6 || i % 10 == 9) {
					cnt++;
				}
				switch(cnt) {
				case 0 :
					System.out.printf("%d\t", i);
					break;
				case 1 :
					System.out.print("♥\t");
					break;
				case 2 :
					System.out.print("♥♥\t");
					break;
		} 
				if(i%10 == 0) {
				System.out.println();
				}
		}
		
		
		
//		for(int i = 1; i<=50; i++) {
//			if(i/10 == 3 || i/10 == 6 || i/10 == 9) {
//				System.out.print(" * ");
//			}
//				if(i % 3 == 0 ||i % 3 == 3 ||i % 3 == 6 || i % 3 ==9) {
//					System.out.print(" * ");
//				} else {
//			System.out.printf("%2d ", i);
//		} 
//		}
        
	}//end main

}
