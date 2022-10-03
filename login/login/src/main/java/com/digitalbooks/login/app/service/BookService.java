package com.digitalbooks.login.app.service;

import java.util.List;

import com.digitalbooks.login.app.model.Book;

public interface BookService {
	
	public String createBook(Book book);
	
	public String updateBook(Book book);
	
	public List<com.digitalbooks.login.app.entity.Book> findByAll();


}
