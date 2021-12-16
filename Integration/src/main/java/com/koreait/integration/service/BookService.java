package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import com.koreait.integration.domain.Book;
import com.koreait.integration.domain.Query;

public interface BookService {
	
	public int addBook(Book book);
	public List<Book> findAllBook();
	public List<Book> findBook(Query query);
	public int deleteBook(Long no);
	
}
