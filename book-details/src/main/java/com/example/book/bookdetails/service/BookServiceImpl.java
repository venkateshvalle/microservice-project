package com.example.book.bookdetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.bookdetails.entity.BookEntity;
import com.example.book.bookdetails.model.BookModel;
import com.example.book.bookdetails.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookModel> getBookDetails() {
		List<BookEntity> books = (List<BookEntity>) bookRepository.findAll();
		return books.stream().map(book -> convertEntityToModel(book)).collect(Collectors.toList());
	}
	
	private BookModel convertEntityToModel(BookEntity book) {
		BookModel model = new BookModel();
		BeanUtils.copyProperties(book, model);

		return model;
	}
	public BookEntity saveBookDetailes(BookModel book) {
	
		bookRepository.save(book);
		return book;
		
	}
	

}
