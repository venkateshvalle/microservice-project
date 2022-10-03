package com.digitalbooks.login.app.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.digitalbooks.login.app.daoimpl.BookDaoImpl;
import com.digitalbooks.login.app.entity.Payment;
import com.digitalbooks.login.app.model.Book;
import com.digitalbooks.login.app.repository.PaymentRepository;
import com.digitalbooks.login.app.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDaoImpl bookDao;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Value("${kafka.reuest.topic}")
	private String requestTopic;
	
	@Autowired
	private ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate;

	@Override
	public String createBook(com.digitalbooks.login.app.entity.Book book) {

		Date date = new Date();
		long l = date.getTime();
		Timestamp timestamp = new Timestamp(l);
		book.setPublishedDate(timestamp);
		book = bookDao.createBook(book);
		if (book.getBookId() != 0) {
			return "Book Created successfully";
		} else {
			return "Error in creating the Book";
		}
	}

	public String updateBook(com.digitalbooks.login.app.entity.Book book) {
		bookDao.createBook(book);
		return "Book Updated successfully";
	}

	public List<com.digitalbooks.login.app.entity.Book> getBooks(String category, String author, Double price,
			String publisher) {
		List<com.digitalbooks.login.app.entity.Book> result = new ArrayList<>();
		if (category == null && author == null && price == null && publisher == null) {
			result = bookDao.getAllBooks();
		} else {
			result = bookDao.getBooks(category, author, price, publisher);

		}
		return result;
	}

	public String buyBook(Book book) {
		Payment payment = new Payment();
		try {
			
			if (book.getReader() != null && book.getReader().getEmail() != null && book.getReader().getName() != null) {
				ProducerRecord<String, String> record = new ProducerRecord<>(requestTopic, null,
						book.getReader().getName(), book.getReader().getName());
				RequestReplyFuture<String, String, String> future = replyingKafkaTemplate.sendAndReceive(record);

				ConsumerRecord<String, String> response = future.get();
				if (response.value() == null) {
					return "Reader is not registered";
				}
				Optional<com.digitalbooks.login.app.entity.Book> optBookEntity = bookDao.findByBookId(book.getBookId());
				if (optBookEntity.isEmpty()) {
					return "Book doesnot exists";
				} else {
					payment.setBookId(book.getBookId());
					payment.setReaderId(Integer.valueOf(response.value()));
					payment.setReaderMail(book.getReader().getEmail());
					payment = paymentRepository.save(payment);
					
				}
			} else {
			  return "Reader name and Mail is mandatory";
		  }
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return "Error in backend.., Please try again..";
		}

		return "Please find the PaymentId For your refference" + " "+ payment.getPaymentId();

	}
	
	public List<com.digitalbooks.login.app.entity.Book> getAllBooks(String readerMail) {
		List<com.digitalbooks.login.app.entity.Book> result = new ArrayList<>();
		List<Payment> list = paymentRepository.findByReaderMail(readerMail);
		Set<Integer> set = list.parallelStream().map(i -> i.getBookId()).collect(Collectors.toSet());
		result = bookDao.findBooks(set);
		return result;
	}
	
	public List<com.digitalbooks.login.app.entity.Book> getAllBooksbyPaymentId(int paymentId) {
		List<com.digitalbooks.login.app.entity.Book> result = new ArrayList<>();
		List<Payment> list = paymentRepository.findByPaymentId(paymentId);
		Set<Integer> set = list.parallelStream().map(i -> i.getBookId()).collect(Collectors.toSet());
		result = bookDao.findBooks(set);
		return result;
	}
	
	@KafkaListener(topics = "Payment_Book", groupId = "group-id")
	@SendTo
	public String handle(String readerMail) {
		String st  = null;
		try {
		System.out.println("Calculating Result...");
		List<com.digitalbooks.login.app.entity.Book> result = new ArrayList<>();
		List<Payment> list = paymentRepository.findByReaderMail(readerMail);
		Set<Integer> set = list.parallelStream().map(i -> i.getBookId()).collect(Collectors.toSet());
		result = bookDao.findBooks(set);
		ObjectMapper mapper = new ObjectMapper();
		 st = mapper.writeValueAsString(result);
		} catch (Exception e) {
			System.out.print("Exception " + e);
		}
		return st;
	}

}
