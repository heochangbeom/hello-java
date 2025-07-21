package chap05;

public class Arr204 {

	public static void main(String[] args) {
		// 배열 생성, 배열 데이터 활용
		// 204p 예제
		int[] scores;                      //배열 생성 선언 방법1
		scores = new int[] { 83, 90, 87 }; //힙영역에서 배열객체를 만들고 값을 넣은 다음 그 배열객체의 주소를 scores 배열변수에 저장하는 거임
		int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);
		
		
		
		int sum2 = add(new int[] {83, 90, 87});  //배열 생성 방법2
		System.out.println("총합 : " + sum2);
		System.out.println();
		
		
		//int 형의 배열 선언, 크기 : 5
		//배열에 50~100사이의 수 5개 입력
		int[] ran = new int[5];
		for(int i=0; i<ran.length; i++) {
			ran[i] = (int)(Math.random() *51) +50;
		}
		//배열의 합
		int result = add(ran);
		System.out.println("배열의 합 = " + result);
		System.out.println("배열의 합 = " + add(ran));
		
		

		
	}// end main

	public static int add(int[] scores) {
		int sum = 0;
		for(int i = 0; i<3; i++) {
			sum += scores[i];
		}
		System.out.println("배열의 합 = " + sum);
		return sum;
	}//end add

}// end class
