package com.digitalbooks.login.app.service;

import java.util.List;

import com.digitalbooks.login.app.model.Book;

public interface BookService {

	public String createBook(com.digitalbooks.login.app.entity.Book book);

	public String updateBook(com.digitalbooks.login.app.entity.Book book);
	
	public List<com.digitalbooks.login.app.entity.Book> getBooks(String category, String author, Double price, String publisher);
	
	public String buyBook(Book book);
	
	public List<com.digitalbooks.login.app.entity.Book> getAllBooks(String readerMail);

	public List<com.digitalbooks.login.app.entity.Book> getAllBooksbyPaymentId(int paymentId);


}
