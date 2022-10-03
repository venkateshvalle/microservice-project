package com.digitalbooks.login.app.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitalbooks.login.app.dao.BookDao;
import com.digitalbooks.login.app.entity.Book;
import com.digitalbooks.login.app.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book createBook(Book entity) {
		return bookRepository.save(entity);
	}
	
	public Optional<Book> findByBookId(int bookId) {
		return bookRepository.findByBookId(bookId);
	}

	@Override
	public List<Book> findByAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}


}
