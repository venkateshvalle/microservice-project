package com.reader.serviceInf;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.reader.entity.Book;

@FeignClient(name="BOOK-SERVICE")
public interface BookConsumerService {
	
	@GetMapping("/api/v1/digitalBooks/books/{emailId}/books")
    public List<Book> getBookData(@PathVariable String emailId);

	@GetMapping("/api/v1/digitalBooks/books/{paymentId}")
	public List<Book> getAllPurchasedBookByPaymentId(@PathVariable int paymentId);

}
