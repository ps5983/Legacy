package com.siit21c.hello.controller;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siit21c.hello.dao.BookDaoImpl;
import com.siit21c.hello.service.BookService;
import com.siit21c.hello.utill.Pager;
import com.siit21c.hello.vo.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	private Log log = LogFactory.getLog(BookDaoImpl.class);//로그선언 or getLog(this.getClass());
	@Autowired
	BookService service;
	
	@RequestMapping("/dummy")
	String dummy() {
		
		service.dummy();
		return "redirect:list";
	}
	
	@RequestMapping("/init")
	String init() {
		service.init();
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	String liSt(Model model, Pager pager) {
		
		List<Book> list = service.list(pager);
		
		model.addAttribute("list", list);
		return "list";
	}
	
	
	
	  @RequestMapping(value = "/insert", method=RequestMethod.GET) //value인 uri를 처리하는데 그중에서 get이 붙은 메소드만 처리하겠다 
	  String insert() { 
	  
		  return "insert";
	  }
	 
	@RequestMapping(value = "/insert", method= RequestMethod.POST)//위에꺼 주석 풀고 코드 고쳐서 해야함 여기선 request get 중복이니깐 빼고 수정!!!!!!!!!!!!!!!!!!!!!!!1111
	String insert(Book book) {
		 service.insert(book);
		//log.debug("############################book -{}");
		return "redirect:list";//요청 처리하고 response, request 2번 발생해서 2번째에 요청한 redirect :list를 받아 가져와서 덮어씌어줌
	}
	
	
	@RequestMapping(value = "/update", method=RequestMethod.GET) //value인 uri를 처리하는데 그중에서 get이 붙은 메소드만 처리하겠다
	String update(int bookid, Model model) {//model : id를 담아오기위해 사용 , bookid는 식별위해
		 Book item = service.item(bookid);
		 
		model.addAttribute("item", item);//모델의 item 에 bookid를 받아서 넘어감
		 
		return "update";
	}
	@RequestMapping(value = "/update", method=RequestMethod.POST) 
	String update(Book book) {
		 service.update(book);
		
		return "redirect:list";//요청 처리하고 response, request 2번 발생해서 2번째에 요청한 redirect :list를 받아 가져와서 덮어씌어줌
	}
	
	
	@RequestMapping("/delete") 
	String delete(int bookid) {
		 service.delete(bookid);
		
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	String view(int bookid, Model model) {
		Book item = service.item(bookid);
		model.addAttribute("item",item);
		return "view";
	}
	
	@RequestMapping("/search") 
	String search(Model model,Book book) { 
		List<Book> list = service.list(book);
		
		model.addAttribute("list", list);
		return "redirect:list";
	}
	
	
	
}
