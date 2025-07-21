package chap06_01;

public class Book {
	//필드:field
	private String name;
	private int num;
	private price;
	
	//생성자: constructor
	Book( int num, String name, int price){
		this.name = name;
		this.num  = num;
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNum(int num) {
		this.num = num;
	}

}//end class
