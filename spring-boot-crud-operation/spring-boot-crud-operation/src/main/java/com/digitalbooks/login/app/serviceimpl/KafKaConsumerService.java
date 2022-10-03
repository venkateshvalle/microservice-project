package com.digitalbooks.login.app.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.digitalbooks.login.app.entity.Book;
import com.digitalbooks.login.app.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafKaConsumerService {
	
	@Autowired
	BookService bookService;
	
	public static final String GROUP_ID = "group_id";

	@KafkaListener(topics = "Book_List", groupId = GROUP_ID)
	public void consume(String message) throws IOException {
		System.out.println(String.format("Message recieved -> %s", message));
		ObjectMapper mapper = new ObjectMapper();
		Book entity = mapper.readValue(message, Book.class);
		String result = bookService.createBook(entity);
		System.out.println(result);
	}
	
//	@KafkaListener(topics = "Book_Update", groupId = GROUP_ID)
//	public void consumerUpdate(String message) throws JsonMappingException, JsonProcessingException {
//		System.out.println(String.format("Message recieved -> %s", message));
//		ObjectMapper mapper = new ObjectMapper();
//		Book entity = mapper.readValue(message, Book.class);
//		String result = bookService.updateBook(entity);
//		System.out.println(result);
//	}

}
