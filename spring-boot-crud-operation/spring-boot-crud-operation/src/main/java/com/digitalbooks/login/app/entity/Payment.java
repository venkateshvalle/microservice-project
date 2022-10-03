package com.digitalbooks.login.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Payment_ID")
	private int paymentId;
	
	@Column(name = "Reader_ID")
	private int readerId;
	
	@Column(name = "Reader_Mail")
	private String readerMail;
	
	@Column(name = "Book_ID")
	private int bookId;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getReaderMail() {
		return readerMail;
	}

	public void setReaderMail(String readerMail) {
		this.readerMail = readerMail;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	
}
