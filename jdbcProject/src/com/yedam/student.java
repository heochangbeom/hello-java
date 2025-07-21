package com.yedam;
// 속성=>필드.
// 기능=>메소드.
// 속성=>학생번호, 이름, 연락처, 혈액형
public class student {
	private int stdNo; // std_no std_no
	private String stdName;
	private String phone;
	private String bloodType;
	
	//생성자.
	public Student() {
		//기본생성자.
	};
	public Student(int stdNo, String stdName, String phone, Sring bloodType) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.phone = phone;
		this.bloodType = bloodType;
		
	}
	
	//메소드(getter,setter)
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	} //end of setStdNo.
	public int getStdNo() {
		return stdNo; 
	}
	
	public void setstdName(String stdName) {
		this.stdName = stdName;
	} //end of setStdNo.
	public String getstdName() {
		return stdName; 
	}
	
	public void setphone(String phone) {
		this.phone = phone;
	} //end of setStdNo.
	public String getphone() {
		return phone; 
	}
	
	public void setbloodType(String bloodType) {
		this.bloodType = bloodType;
	} //end of setStdNo.
	public String getbloodType() {
		return bloodType; 
	}
}
