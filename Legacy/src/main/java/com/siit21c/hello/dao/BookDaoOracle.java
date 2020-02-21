package com.siit21c.hello.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siit21c.hello.utill.Pager;
import com.siit21c.hello.vo.Book;

@Repository(value = "oracleDao")//
public class BookDaoOracle implements BookDao{ 

	@Autowired
	SqlSession sql;//마이바티스 연결 
	
	@Override
	public List<Book> list() {
		
		return sql.selectList("Book.all");
	}

	@Override
	public Book item(int bookid) {
		
		return sql.selectOne("Book.item",bookid);
	}

	@Override
	public void insert(Book book) {
		sql.insert("Book.insert",book);
	}

	@Override
	public void update(Book book) {
		sql.update("Book.update",book);
		}

	@Override
	public void delete(int bookid) {
		sql.delete("Book.delete", bookid);
	}

	/*
	 * @Override public Book getid(int bookid) {
	 * 
	 * return sql.selectOne("Book.getid",bookid); }
	 */

	@Override
	public List<Book> list(Pager pager) {
		
		return sql.selectList("Book.list",pager);
	}

	@Override
	public float total(Pager pager) {
			int total = sql.selectOne("Book.total",pager);
		return (float) total;
	}

	@Override
	public List<Book> search(String keyword) {
		
		
		return sql.selectList("Book.search", keyword);
	}

	@Override
	public List<Book> list(Book book) {
		// TODO Auto-generated method stub
		return null;
	}


}
