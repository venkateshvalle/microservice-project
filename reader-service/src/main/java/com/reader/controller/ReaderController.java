package com.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reader.entity.Book;
import com.reader.serviceInf.ReaderService;

@RestController
@RequestMapping("/api/v1/digitalbooks/readers")
public class ReaderController {
	
	@Autowired
	private ReaderService readerService;
	
	@GetMapping("/{emailId}/books")
	public List<Book> getAllPurchasedBooks(@PathVariable String emailId) {
		return readerService.getAllPurchasedBooks(emailId);
	}
	
	@GetMapping("/{emailId}/books/{paymentId}")
	public List<Book> getAllPurchasedBooks(@PathVariable int paymentId) {
		return readerService.getAllPurchasedBookByPaymentId(paymentId);
	}

}
