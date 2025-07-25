package com.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BookMapper;
import com.yedam.vo.Book;

public class Main {
	
	
	public static void main(String[] args) {
		BookControl ctrl = new BookControl();
		ctrl.exe();
	}
	
	void backup() {
		//RunExe는 Runnable 구현하는 클래스.
		RunExe exe = new RunExe();
		exe.run(); // 인터페이스 - 구현클래스.
		
//		DBUtil util = new DBUtil(); //인스턴스를 통해서 메모리 로딩.
		SqlSessionFactory factory = DBUtil.getInstance(); //static 선언.
		SqlSession sqlSession = factory.openSession(); // SqlSession 객체를 반환
		//인터페이스 - 구현클래스.
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		Book book = mapper.selectBook(1001);
		List<Book> list = mapper.selectList(1);

		// 단건조회.
		
//		Book book = sqlSession.selectOne("com.yedam.mapper.BookMapper.selectBook", 1100);
//		List<Book> list = sqlSession.selectList("com.yedam.mapper.BookMapper.selectList");
//		for(Book book : list) {
//			System.out.println(book.toStr());
//		}
	}
}
