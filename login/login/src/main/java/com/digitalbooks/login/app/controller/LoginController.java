package com.digitalbooks.login.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.login.app.model.AuthorLogin;
import com.digitalbooks.login.app.model.Book;
import com.digitalbooks.login.app.service.BookService;
import com.digitalbooks.login.app.service.LoginService;
import com.digitalbooks.login.app.serviceimpl.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api/v1/digitalBooks/author")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	KafkaProducerService KafkaProducerService;
	
	@PostMapping("/signup")
	public String signUp(@RequestBody AuthorLogin authorLogin) {
		
		String result = loginService.signUp(authorLogin);
		return result;
		
	}
	
	@GetMapping("/getVersion")
	public String getVersion() {
		return "v1.o";
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody AuthorLogin authorLogin) {
		String result = loginService.signIn(authorLogin);
		return result;
	}
	
	@PostMapping("/{authorId}/books")
	public String createBook(@PathVariable int authorId, @RequestBody Book book) {
		book.setAuthorId(authorId);
		String result = bookService.createBook(book);
		return result;
	}
	
	@PostMapping("/{authorId}/books/{bookId}")
	public String updateBook(@PathVariable int authorId, @PathVariable int bookId, @RequestBody Book book) throws JsonProcessingException {
		book.setAuthorId(authorId);
		book.setBookId(bookId);
		String result = bookService.updateBook(book);
		return result;
	}
}
