package chap01;

import java.util.Scanner;

public class Scanerr117 {

	public static void main(String[] args) {
		// 통문자 읽어오기
		// 스케너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		//스케너 메소드 이용
		System.out.println("[필수 정보 입력]");
		System.out.print("1. 이름 >>");
		String name = sc.nextLine();
		
		System.out.print("2. 주민번호 앞 6자리 >>");
		String idNumber = sc.nextLine();
		
		System.out.print("3. 전화번호 >>");
		String phone = sc.nextLine();
		
		//출력
		System.out.println();
		System.out.print("]");
		System.out.print("1. 이름 : " + name);
		System.out.print("2. 주민번호 : 앞 6자리 : " + idNumber);
		System.out.print("3. 전화번호 : " + phone);
		
		sc.close();
		
		//121페이지 2번
//		String strNum1 = strNum1.nextLine();
	}

}
