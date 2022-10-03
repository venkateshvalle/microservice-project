package com.example.book.bookdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.bookdetails.entity.BookEntity;
import com.example.book.bookdetails.model.BookModel;
import com.example.book.bookdetails.service.BookService;

@RestController
public class BookConroller {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/book")
	public ResponseEntity<List<BookModel>> findAllBookDetails() {
		return new ResponseEntity<>(service.getBookDetails(), HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public BookEntity saveBook(@RequestBody BookModel book) {
		return service.saveBookDetailes(book);
	}

}
 