package com.siit21c.hello.dao;

import java.util.List;

import com.siit21c.hello.utill.Pager;
import com.siit21c.hello.vo.Book;

public interface BookDao {

	List<Book> list();

	Book item(int bookid);

	void insert(Book book);

	void update(Book book);

	void delete(int bookid);

	/* Book getid(int bookid); */

	List<Book> list(Pager pager);

	float total(Pager pager);

	List<Book> search(String keyword);

	List<Book> list(Book book);



}
