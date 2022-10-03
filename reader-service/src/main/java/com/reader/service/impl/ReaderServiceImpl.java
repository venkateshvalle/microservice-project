package com.reader.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reader.entity.Book;
import com.reader.serviceInf.BookConsumerService;
import com.reader.serviceInf.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService {
	
	@Autowired
	private BookConsumerService bookConsumerService;
	
	//@Autowired
    //private ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate;

	@KafkaListener(topics = "${kafka.reuest.topic}", groupId = "${kafka.group.id}")
	@SendTo
	public String handle(String reader) {
	   if(reader.equalsIgnoreCase("james"))
		return "1";
	   else {
		   return "0";
	   }

	}

//	@Override
//	public List<Book> getAllPurchasedBooks(String emailId) {
//		try {
//			ProducerRecord<String, String> record = new ProducerRecord<>("Payment_Book", null, emailId, emailId);
//			RequestReplyFuture<String, String, String> future = replyingKafkaTemplate.sendAndReceive(record);
//			ConsumerRecord<String, String> response = future.get();
//			ObjectMapper mapper = new ObjectMapper();
//			List<Book> booksList = new ArrayList<>();
//			booksList = mapper.readValue(response.value(), List.class);
//			return booksList;
//		} catch (Exception e) {
//			return null;
//		}
//	}
	
	public List<Book> getAllPurchasedBooks(String emailId) {
		try {
			List<Book> booksList = new ArrayList<>();
			booksList = bookConsumerService.getBookData(emailId);
			return booksList;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Book> getAllPurchasedBookByPaymentId(int paymentId) {
		try {
			List<Book> booksList = new ArrayList<>();
			booksList = bookConsumerService.getAllPurchasedBookByPaymentId(paymentId);
			return booksList;
		} catch (Exception e) {
			return null;
		}
	}
}
