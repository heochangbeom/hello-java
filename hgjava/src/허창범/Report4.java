package 허창범;

import java.util.Scanner;

public class Report4 {

	public static void main(String[] args) {
		// 숫자 추측 
        Scanner sc  = new Scanner(System.in);
        int rannum  = (int) (Math.random() *100) +1;
//        int usernum = Integer.parseInt(sc.nextLine());
        boolean run = true;
        
        while(run){
        	int usernum = Integer.parseInt(sc.nextLine());
        if(rannum > usernum) {
        	System.out.println("업!");
        } else if(rannum < usernum) {
        	System.out.println("다운!");
        } else {
        System.out.println("정답!");
        run = false;
        }
        
		
	}
        sc.close();

}//end main
	
}
