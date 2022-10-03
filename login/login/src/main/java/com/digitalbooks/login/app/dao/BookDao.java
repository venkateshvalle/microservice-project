package com.digitalbooks.login.app.dao;

import java.util.List;
import java.util.Optional;

import com.digitalbooks.login.app.entity.Book;

public interface BookDao {
	

  public Book createBook(Book book);
  
  public Optional<Book> findByBookId(int bookId);
  
  public List<Book> findByAll();

}
