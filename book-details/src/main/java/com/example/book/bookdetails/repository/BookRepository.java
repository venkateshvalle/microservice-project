package com.example.book.bookdetails.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.book.bookdetails.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

	
}
  