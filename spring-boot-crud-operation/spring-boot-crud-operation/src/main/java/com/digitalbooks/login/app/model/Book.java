package com.digitalbooks.login.app.model;

public class Book {
	
	private int bookId;
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	private String title;
	
	private String category;
	
	private byte[] logo;
	
	private double price;
	
	private String publisher;
	
	private boolean active;
	
	private String content;
	
	private int authorId;
	
	private Reader reader;

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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