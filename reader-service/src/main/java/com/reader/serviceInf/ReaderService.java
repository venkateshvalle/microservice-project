package com.reader.serviceInf;

import java.util.List;

import com.reader.entity.Book;

public interface ReaderService {

	public List<Book> getAllPurchasedBooks(String emailId);

	public List<Book> getAllPurchasedBookByPaymentId(int paymentId);
}
