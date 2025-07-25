package com.yedam.vo;

public class Book {
	//필드
	private int id;
	private String title;
	private String author;
	private int price;
	
	
	@Override //부모클래스(Object)의 toString() 자식이 물려받음. 
	//자기 자신의 입맛에 맞게 부모 클래스의 메소드를 재정의하는 거=> override.
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	public String toStr() {
		return "id: " + id + ", title : " + title + ", author: " + author + ", price: " + price;
	}
	
	//메소드
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String showBrief() {
		return " " + id + " " + title + " " + price;
	}

}
