package com.example.book.bookdetails.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BookModel {
	/**
	 * 
	 */
	private static final long serialVersiononUID = 1L;
	private long id;
	private String title;
	private String category;
	private String image;
	private Double price;
	private String publisher;
	private String content; 
	

}
