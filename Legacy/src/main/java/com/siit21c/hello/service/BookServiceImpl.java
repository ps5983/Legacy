package com.siit21c.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.siit21c.hello.dao.BookDao;
import com.siit21c.hello.utill.Pager;
import com.siit21c.hello.vo.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	@Qualifier(value = "oracleDao")
	BookDao dao;
	
	@Override
	public List<Book> list(Pager pager){
		float total = dao. total(pager);
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public Book item(int bookid) {
		
		return dao.item(bookid);
		
	}
	
	@Override
	public void insert(Book book) {
		
		dao.insert(book);
	}

	@Override
	public void update(Book book) {
		
		dao.update(book);
	}

	@Override
	public void delete(int bookid) {
		
		dao.delete(bookid);
	}

	@Override
	public void dummy() {
		for(int i=0;i<100;i++) {
			Book book = new Book();
			
			book.setBookid(i);
			book.setBookname(i+"번째 기묘한 이야기");
			book.setPublisher("출산사" + i);
			book.setPrice((1000*i)+10000);
			dao.insert(book);
			
		}
				
	}

	@Override
	public void init() {
		List<Book> list = dao.list();
		
		/* dao.bookid bookid = new bookid(); */
		/* Book bookid = ner Book(); */
		
		for(Book book : list) 
			dao.delete(book.getBookid());
	}

	@Override
	public List<Book> list(Book book) {

		return dao.list(book);
	}

		
		
		/* bookid = 0; */
	

	/*
	 * @Override public Book getid(int bookid) {
	 * 
	 * 
	 * return dao.getid(bookid); }
	 */
}
