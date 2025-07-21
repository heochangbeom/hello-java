package chap01;

public class Hello {

	public static void main(String[] args) {
		// 출력문 
		System.out.println("hello java!!!");
		int a = 7;
		System.out.println(a);
		
		//변수 값 교환
		int x = 10;
		int y = 50;
		int temp = y;
		y = x;
		x = temp;
		System.out.println("x=" + x + " y= " + y);
		
		//기본타입
		char font = 'A';
		int intchar = font + 1;
		char font2 = (char)intchar;
		System.out.println(font);
		System.out.print(intchar + "\n");
		System.out.println(font2);
		
		//문자열을 저장하기 위해서는 String이라는 객체타입 변수를 생성해야함
		String str = "홍길동";
		System.out.println(str);
		
		//연산 : 정수 => 기본타입 int, 실수 => 기본타입 double
		int su1 = 1;
		int su2 = 3;
//		int result = su1/su2;
		double result = su1/su2;       //int/int는 걍 int 값임 그래서 0.0임
		System.out.println(result);
		
		//결과 = 0.33333333...
		result = (double) su1 / su2;
		System.out.println(result);
		
		//문자열 비교
		String str1 = "신용권" ;
	    String str2 = "신용권";
	    String str3 = new String("신용권");
	    boolean resultStr = str1 == str2;    //주소비교 ==> 같은 객체인지 확인
	    boolean resultobj = str2 == str3;
		System.out.println(resultStr);       //같은 객체
		System.out.println(resultobj);       //다른 객체
		System.out.println(str1.equals(str3)); //객체데이터 비교
		
		// &=, |=, ^= 연산
		int r1 = 1 & 2;
		int r2 = 1 | 2;
		int r3 = 1 ^ 2;
		System.out.println("and 연산 = " + r1);
		System.out.println("or 연산 = "  + r2);
		System.out.println(" 연산 = " + r1);
		
		// 수 20이 4의 배수이면서 5의 배수인지 체크
		// 결과 = 20은 4와 5의 배수 입니다
		// 아니면 20은 4와 5의 배수가 아닙니다
		int num = 55;
		if (num % 4 == 0 && num % 5 == 0) {
			System.out.printf("%d은 4와 5의 배수입니다\n", num);
		} else {
			System.out.printf("%d은 4와 5의 배수가 아닙니다\n", num);
		}
		
		//홀수 짝수 구별 (삼항연산자)
		// 수는 20을 이용
		String result12 = (num%2 == 00) ? "짝수" : "홀수" ;
		System.out.println(result12);
	}//end

}//end
