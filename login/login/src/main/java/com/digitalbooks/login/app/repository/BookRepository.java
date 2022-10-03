package com.digitalbooks.login.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.digitalbooks.login.app.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>, JpaRepository<Book, Integer> {
	

	public Optional<Book> findByBookId(int bookId);
	

}
