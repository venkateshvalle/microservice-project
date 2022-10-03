package com.digitalbooks.login.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Book_Id")
	private int bookId;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Category")
	private String category;
	
	@Column(name = "logo")
	private byte[] logo;
	
	@Column(name = "Price")
	private Double price;
	
	@Column(name = "Publisher")
	private String publisher;
	
	@Column(name = "Active")
	private boolean active;
	
	@Column(name = "Content")
	private String content;
	
	@Column(name = "Published_Date")
	private Timestamp publishedDate;

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "Author")
	private String author;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Timestamp getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
