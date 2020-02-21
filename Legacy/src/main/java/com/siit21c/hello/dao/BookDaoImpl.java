package com.siit21c.hello.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.siit21c.hello.utill.Pager;
import com.siit21c.hello.vo.Book;

@Repository(value = "localDao")
public class BookDaoImpl implements BookDao {
	
	private Log log = LogFactory.getLog(BookDaoImpl.class);//로그선언 or getLog(this.getClass());
	List<Book> list;
	
	public BookDaoImpl() {
		list = new ArrayList<Book>();
		
		Book book = new Book();
		book.setBookid(1);
		book.setBookname("javaprogramming");
		book.setPublisher("Hanbit");
		book.setPrice(200000);
		list.add(book);
		
		book = new Book();
		book.setBookid(1);
		book.setBookname("cpp");
		book.setPublisher("Sangneung");
		book.setPrice(124444);
		list.add(book);
		
		book = new Book();
		book.setBookid(1);
		book.setBookname("Robi");
		book.setPublisher("Handler");
		book.setPrice(55555);
		list.add(book);
	}
	
	@Override
	public List<Book> list(){
		
		return list;
	}

	@Override
	public Book item(int bookid) {
		for(Book item : list) {
			if(item.getBookid()== bookid)
				return item;
		}
		log.debug("########################### ");
		return null;
	}

	@Override
	public void insert(Book book) {
		list.add(book);
	}

	@Override
	public void update(Book book) {
		for(Book item : list) {
			if(item.getBookid()== book.getBookid()) {
				item.setBookname(book.getBookname());
				item.setPublisher(book.getPublisher());
				item.setPrice(book.getPrice());
				
			}
		}
	}

	@Override
	public void delete(int bookid) {
		for(Book item : list) {
			if(item.getBookid()== bookid) {
				list.remove(item);
				break;
			}
		}
	}

	/*
	 * @Override public Book getid(int bookid) {
	 * 
	 * return null;
	 * 
	 * }
	 */

	@Override
	public List<Book> list(Pager pager) {
		List<Book> books = new ArrayList<Book>();
		
		int start = (pager.getPage() -1 ) * pager.getBunch()+1;
		int end = (pager.getPage() * pager.getBunch());
		
		for(int i = start; i < list.size() && i<= end; i++) {
			books.add(list.get(i-1));
		}
		
		return books;
	}

	@Override
	public float total(Pager pager) {
		return list().size();
	}

	@Override
	public List<Book> search(String keyword) {
		List<Book> books = new ArrayList<Book>();
		
		return books; 
		
	}

	@Override
	public List<Book> list(Book book) {
		// TODO Auto-generated method stub
		return null;
	}


}
