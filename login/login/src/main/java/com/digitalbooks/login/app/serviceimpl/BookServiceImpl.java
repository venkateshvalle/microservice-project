package com.digitalbooks.login.app.serviceimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.digitalbooks.login.app.dao.LoginDao;
import com.digitalbooks.login.app.daoimpl.BookDaoImpl;
import com.digitalbooks.login.app.entity.AuthorLoginEntity;
import com.digitalbooks.login.app.model.Book;
import com.digitalbooks.login.app.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDaoImpl bookDao;
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@Override
	public String createBook(Book book)  {
		try {
			com.digitalbooks.login.app.entity.Book bookEntity = new com.digitalbooks.login.app.entity.Book();
			Optional<AuthorLoginEntity> entityResponse = loginDao.findByUserId((book.getAuthorId()));
			AuthorLoginEntity authorLoginEntity = new AuthorLoginEntity();
			if (entityResponse.isEmpty()) {
				return "Author doesnot exists";
			} else {
				authorLoginEntity = entityResponse.get();
			}

			BeanUtils.copyProperties(book, bookEntity);
			Date date = new Date();
			long l = date.getTime();
			Timestamp timestamp = new Timestamp(l);
			bookEntity.setPublishedDate(timestamp);
			bookEntity.setAuthor(authorLoginEntity.getUserName());
			ObjectMapper mapper = new ObjectMapper();
			kafkaProducerService.sendMessage(mapper.writeValueAsString(bookEntity));
			return "Book Created successfully";
		} catch (Exception e) {
			return "Error in creating the Book";
		}
		
	}

	public String updateBook(Book book) {
		try {
			com.digitalbooks.login.app.entity.Book bookEntity = new com.digitalbooks.login.app.entity.Book();
			Optional<AuthorLoginEntity> entityResponse = loginDao.findByUserId((book.getAuthorId()));

			if (entityResponse.isEmpty()) {
				return "Author doesnot exists";
			} else {
				Optional<com.digitalbooks.login.app.entity.Book> optBookEntity = bookDao.findByBookId(book.getBookId());
				if (optBookEntity.isEmpty()) {
					return "Book doesnot exists";
				} else {
					bookEntity = optBookEntity.get();
					if (book.getCategory() != null && book.getCategory() != "") {
						bookEntity.setCategory(book.getCategory());
					}
					if (book.getContent() != null && book.getContent() != "") {
						bookEntity.setContent(book.getContent());
					}
					if (book.getPrice() != 0.0) {
						bookEntity.setPrice(book.getPrice());
					}
					if (book.getPublisher() != null && book.getPublisher() != "") {
						bookEntity.setPublisher(book.getPublisher());
					}
					if (book.getTitle() != null && book.getTitle() != "") {
						bookEntity.setTitle(book.getTitle());
					}
					if (book.getActive() == true || book.getActive() == false) {
						bookEntity.setActive(book.getActive());
					}
					ObjectMapper mapper = new ObjectMapper();
					kafkaProducerService.sendMessage(mapper.writeValueAsString(bookEntity));
					return "Book updated successfully";
				}
			}
		} catch (Exception e) {
			return " Erroor while updating the Book, Please try again...";
		}
	}
	
	
	public List<com.digitalbooks.login.app.entity.Book> findByAll() {
		return bookDao.findByAll();
		
	}

}
