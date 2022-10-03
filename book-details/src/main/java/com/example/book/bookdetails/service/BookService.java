package com.example.book.bookdetails.service;

import java.util.List;

import com.example.book.bookdetails.entity.BookEntity;
import com.example.book.bookdetails.model.BookModel;

public interface BookService {

	List<BookModel> getBookDetails();

}
