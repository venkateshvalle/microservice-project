package com.digitalbooks.login.app.daoimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitalbooks.login.app.dao.BookDao;
import com.digitalbooks.login.app.entity.Book;
import com.digitalbooks.login.app.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	BookRepository bookRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Book createBook(Book entity) {
		return bookRepository.save(entity);
	}

	@Override
	public List<Book> getBooks(String category, String author, Double price, String publisher) {
		List<Book> list = bookRepository.findByCategoryOrAuthorOrPriceOrPublisher(category, author, price, publisher);
	    return list;	
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> list = bookRepository.findAll();
	    return list;	
	}
	
	public Optional<Book> findByBookId(int bookId) {
		return bookRepository.findByBookId(bookId);
	}
	
	public List<Book>  findBooks(Set<Integer> list) {
		return bookRepository.findByBookIdIn(list);
	}
}
