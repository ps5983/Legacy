package com.siit21c.hello.service;

import java.util.List;

import com.siit21c.hello.utill.Pager;
import com.siit21c.hello.vo.Book;

public interface BookService {

	List<Book> list(Pager pager);

	void insert(Book book);
	
	void update(Book book);

	Book item(int bookid);

	void delete(int bookid);

	void dummy();
	
	void init();
	
	List<Book> list(Book book);

	/* Book getid(int bookid); */
}    
