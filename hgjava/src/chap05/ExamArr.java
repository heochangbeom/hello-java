package chap05;

public class ExamArr {

	public static void main(String[] args) {
		// 배열 과제1
		int[] ran = new int[10];
		int sum = 0;
		int max = 0;
		int min = 100;
		for(int i = 0; i<ran.length; i++) {
			ran[i] = (int)(Math.random() *100) + 1;
			sum +=  ran[i];
			System.out.print(ran[i]);
			System.out.print("\s");
			
			if(ran[i] > max) {
				max = ran[i];
			}
			if(ran[i] < min) {
				min = ran[i];
			}
		}
		System.out.println();
		System.out.println("배열의 합    : " + sum);
		System.out.println("배열의 최대값 : " + max);
		System.out.println("배열의 최소값 : " + min);
		
		
		//배열의 요소 중 4의 배수 출력
		//4의 배수 갯수 출력
		int cnt = 0;
		for(int j= 0; j<ran.length; j++) {
			if(ran[j] % 4 == 0) {
				System.out.print(ran[j]+ " " );
				cnt++;
		   }
		} 		System.out.println();
		System.out.println("4의 배수 갯수" +cnt);
		
		
		//2차원 배열
		//2차원 배열 선언
		int[][] twoArr = {
				{80, 90},
				{70, 60, 50}
		};
		//2차원출력
		for(int i = 0; i<twoArr.length; i++) {
			for(int j = 0; j< twoArr[i].length; j++) {
				System.out.printf("| %d ", twoArr[i][j]);
			}
			System.out.println("|");
		}
		
		System.out.println();
		//과제2
		int[][] port = {
				{1,2,3},
				{1,2},
				{1},
				{1,2,3}
		};
		for(int i = 0; i<port.length; i++) {
			for(int j = 0; j<port[i].length; j++) {
				System.out.printf("| %d ", port[i][j]);
			}
			System.out.println("|");
		}
		
		int sum1 = 0;
		int[][] chair = new int[3][10];
		for(int i = 0; i<chair.length; i++) {
			for(int j = 0; j<chair[i].length; j++) {
				int human = (int) (Math.random() *2);
				chair [i][j] = human;
				sum1 += chair [i][j];
				System.out.print(chair [i][j] + "\s");
				
			}
			System.out.println();
		}
		System.out.printf("관객수 : %d명", sum1);
		System.out.println();
		System.out.println();
		
		
		
		
		
		

		
		double avg1 = 0.0;
		double avg2 = 0.0;
		double avg3 = 0.0;
		int[][] all = new int[3][5];
		for(int i = 0; i<all.length; i++) {
			int    hap  = 0;
			double avg  = 0.0;
			for(int j = 0; j<all[i].length; j++) {
				all[i][j] = (int)(Math.random() *51) +50;
				hap += all[i][j];
				avg = (double) hap/all[i].length;
				System.out.print(all[i][j] + " ");
			}
			System.out.println();
			if(i == 0) {
				avg1 = avg;
			}else if(i == 1){
				avg2 = avg;
			}else if(i == 2){
				avg3 = avg;
			}
			}
			System.out.println();
			System.out.printf("학생1 평균 : %5.2f점\n", avg1);
			System.out.printf("학생2 평균 : %5.2f점\n", avg2);
			System.out.printf("학생3 평균 : %5.2f점\n", avg3);
					
			String[] cardart = { "Clubs", "Diamonds", "Hearts", "Spades"};
			String[] cardnum = { "1","2","3","4","5","6","7","8","9","10","11","12","13"};
			
			int i = 0; 
			i = (int) Math.random() 
	
		
		

	}//end main

}//end class
