package com.example.book.bookdetails.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersiononUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String title;
	private String category;
	private String image;
	private Double price;
	private String publisher;
	private String content; 
	

}
