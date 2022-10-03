package com.digitalbooks.login.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.login.app.model.Book;
import com.digitalbooks.login.app.service.BookService;


@RestController
@RequestMapping("/api/v1/digitalBooks/books")
public class BooksController {
	
	@Autowired
	private BookService bookService;

	
	@GetMapping("/search")
	public List<com.digitalbooks.login.app.entity.Book> getBooks(@RequestParam(required = false) String category, @RequestParam(required = false) String author,
			@RequestParam(required = false) Double price, @RequestParam(required = false) String publisher) {

		      return  bookService.getBooks(category, author, price, publisher);
		
	}
	
	@PostMapping("/buy")
	public String buyBook(@RequestBody Book book) {
		
		String result = bookService.buyBook(book);
		return result;
		
	}
	
	@GetMapping("/{emailId}/books")
	public List<com.digitalbooks.login.app.entity.Book> getBuyedBooks(@PathVariable String emailId) {
		
		List<com.digitalbooks.login.app.entity.Book> result = bookService.getAllBooks(emailId);
		return result;
		
	}
	
	@GetMapping("/{paymentId}")
	public List<com.digitalbooks.login.app.entity.Book> getBuyedBooksByPaymentId(@PathVariable int paymentId) {
		
		List<com.digitalbooks.login.app.entity.Book> result = bookService.getAllBooksbyPaymentId(paymentId);
		return result;
		
	}
	
	
}
