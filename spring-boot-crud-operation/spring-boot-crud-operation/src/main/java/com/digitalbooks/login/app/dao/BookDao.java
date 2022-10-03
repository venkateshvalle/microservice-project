package com.digitalbooks.login.app.dao;

import java.util.List;

import com.digitalbooks.login.app.entity.Book;

public interface BookDao {

	Book createBook(Book entity);
	
	public List<com.digitalbooks.login.app.entity.Book> getBooks(String category, String author, Double price, String publisher);

	List<Book> getAllBooks();


}
