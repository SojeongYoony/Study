package com.koreait.integration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.integration.domain.Book;
import com.koreait.integration.domain.Query;
import com.koreait.integration.service.BookService;

@Controller
public class BookController {

	@Autowired private BookService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping(value="book/addBook", produces="application/json; charset=UTF-8") // == MediaType.APPLICATION_JSON_UTF8_VALUE
	@ResponseBody
	public Map<String, Object> addBook(@RequestBody Book book) { // DO NOT FORGET TO REQUESTBODY ANNOTATION WHEN USING JSON OBJECT
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("result", service.addBook(book));  // map의 result에 DB에 다녀온(service)결과를 담는다
		return map; // Map etc thing auto transfer to JSON object by Jackson
	}
	
	@GetMapping(value="book/findAllBook", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> findAllBook() {
		List<Book> list = service.findAllBook();
		Map<String, Object> map = new HashMap<String, Object>();
		if (list.size() == 0) {
			map.put("status", 500);
			map.put("message", "저장된 Book이 없습니다.");
			map.put("list", null);
		} else {
			map.put("status", 200);
			map.put("message", "전체 " + list.size() + "개의 Book이 있습니다.");
			map.put("list", list);
		}
		return map;
	}
	
	@GetMapping(value="book/findBook", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> findBook(HttpServletRequest request) {
		
		Query query = new Query();
		query.setColumn(request.getParameter("column"));
		query.setQuery(request.getParameter("query"));
		
		List<Book> list = service.findBook(query); // list 
		Map<String, Object> m = new HashMap<String, Object>();
		if (list.size() == 0) {
			m.put("status", 500);
			m.put("message", "검색된 Book이 결과가 없습니다.");
			m.put("list", null);
		} else {
			m.put("status", 200);
			m.put("message", "전체 " + list.size() + "개의 Book이 검색되었습니다.");
			m.put("list", list);
		}
		return m;
	}
	
}
