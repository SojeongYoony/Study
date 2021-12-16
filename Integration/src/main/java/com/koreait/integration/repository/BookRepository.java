package com.koreait.integration.repository;

import java.util.List;
import java.util.Map;

import com.koreait.integration.domain.Book;
import com.koreait.integration.domain.Query;

public interface BookRepository { // DAO
	
	public int insertBook(Book book);
	public List<Book> findAllBook();
	public List<Book> findBook(Query query);  // 실무에서 많이 씀 Map<String, Map<String, Object>>
	public List<Book> findAuthor();
	public int deleteBook(Long no);
}
