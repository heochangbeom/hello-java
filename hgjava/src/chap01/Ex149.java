package chap01;

import java.util.Scanner;

public class Ex149 {

	public static void main(String[] args) {
		//p149 문제1
		//이유
		byte b = 5;
		b = (byte) -b;                //부호를 바꿈으로서 int타입으로 바꾸어야됨
		int result = 10/b;     
		System.out.println();
		
		//p149 문제2
		int x =10;
		int y = 20;
		int z = (++x) + (y--); 
	    System.out.println(z);  //11+20 = 21 y는 연산을 수행한 후 19가 됨
	    
	    //150 문제3
	    boolean stop = true;
	    while(!stop) {
	    } 
	    System.out.println("반복종료");
	    
	    //150 문제4
	    int pencils = 534;
	    int students = 30;
	    
	    int pencilsPerStudent = (int)(pencils/students);
	    System.out.println(pencilsPerStudent);
	    
	    int pencilsLeft = pencils % students;
	    System.out.println(pencilsLeft);
	    
	    //150 문제5
	    int var1 = 5;
	    int var2 = 2;
	    double var3 = (double) var1/var2;
	    double var4 = (double) var3*var2;
	    System.out.println(var4);
	    
	    //151 문제6
	    int value = 356;
	    System.out.println(value/100*100);
	    
	    //151 문제7
	    //이유 float에 값을 소수점자리의 값을 저장하면 정확히 그 값이 저장되는 것이 아니라 근사값이 저장되기 때문에 double타입을 사용해야함
	    double var11 = 10;
	    double var12 = var11 / 100;
	    System.out.println(var12);
	    if(var12 == 0.1) {
	    	System.out.println("10%입니다.");
	    } else {
	    	System.out.println("10%가 아닙니다");
	    }
	    
	    //151 문제8
	    int lengthtop = 5;
	    int lengthBottom = 10;
	    int height = 7;
	    double area = (double) (lengthtop + lengthBottom) * height / 2;
	    System.out.println(area);
	    
	    //151 문제9
	    Scanner sc = new Scanner(System.in);
//	    double firstnum = Double.parseDouble (sc.nextLine());
//	    double secondnum = Double.parseDouble (sc.nextLine());
//	    if (!(firstnum / secondnum == 0)) {
//	    	System.out.println("결과: " + firstnum / secondnum);
//	    } else {
//	    	System.out.println("결과:무한대");
//	    }
	    
	    
	    
	    //152 문제10
	    int var01 = 10;
	    int var02 = 3;
	    int var03 = 14;
	    double var04 = Double.parseDouble(var02 + "." + var03) * (var01/2) * (var01/2);
	    System.out.println("원의 넓이는: " + var04);
	    //원주율 ; var02  * 
	    //원넓이 ; 원주율 * 반지름 * 반지름
	    
	    //152 문제11
//	    System.out.println("아이디:");
//	    String name = sc.nextLine();
//	    
//	    System.out.println("패스워드: ");
//	    String strpassword = sc.nextLine();
//	    int password = Integer.parseInt(strpassword);
//	    
//	    if (name.equals("java") && password == 12345) {
//	    	System.out.println("로그인 성공");
//	    } else if(!(password == 12345)) {
//	    	System.out.println("로그인 실패:패스워드가 틀림");
//	    } else if(!(name == "java")) {
//	    	System.out.println("로그인 실패:아이디가 존재하지 않음");
//	    }
	    
	    
	    String year = sc.nextLine();
	    int year1 = Integer.parseInt(year);
	    if((
	    	
// 	    if (year1 %4 == 0 && )
	    
	    
	    
	}

}
