package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration.domain.Book;
import com.koreait.integration.domain.Query;
import com.koreait.integration.repository.BookRepository;

public class BookServiceImpl implements BookService {

	@Autowired
	private SqlSessionTemplate sqlSession; // DB를 왔다 갔다 하는 Service!
	
	@Override
	public int addBook(Book book) {
		BookRepository repository = sqlSession.getMapper(BookRepository.class);
		return repository.insertBook(book); // DB의 결과를 변수에 담아 반환하지 않고 바로 return 함
	}

	@Override
	public List<Book> findAllBook() {
		BookRepository repository = sqlSession.getMapper(BookRepository.class);
		return repository.findAllBook();
	}
	
	@Override
	public List<Book> findBook(Query query) {
		BookRepository repository = sqlSession.getMapper(BookRepository.class);
		return repository.findBook(query);
	}
	
	@Override
	public int deleteBook(Long no) {
		BookRepository repository = sqlSession.getMapper(BookRepository.class);
		return repository.deleteBook(no);
	}
	
}
