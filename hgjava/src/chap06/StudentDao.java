package chap06;

public class StudentDao {
	//학생 데이터 생성
	//필드
	//생성자 : 기본생성자 => 컴파일 자동 생성
	//메소드

	Student[] stData(){
		
	
	Student[] students = {
			new Student("홍길동", 75,84,85),
			new Student("김길동", 90,50,75),
			new Student("이길동", 87,93,78),
			new Student("황길동", 96,68,95),
			new Student("고길동", 89,95,87),
			new Student("박길동", 65,78,94),
			new Student("허길동", 68,85,94),
			new Student("전길동", 87,93,78),
			new Student("류길동", 96,68,95),
			new Student("남길동", 89,95,87)
	};
	return students;
	
	}
	
}
