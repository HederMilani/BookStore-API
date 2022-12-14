package com.book.bookstore.dtos;

import java.io.Serializable;

public class LivroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String nameAuthor;
	private String text;

	public LivroDTO(){
		super();
	}

	public LivroDTO(Integer id, String title, String nameAuthor, String text){
		super();

		this.id = id;
		this.title = title;
		this.nameAuthor = nameAuthor;
		this.text = text;
	}

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}

	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

	public String getNameAuthor(){
		return nameAuthor;
	}
	public void setNameAuthor(String nameAuthor){
		this.nameAuthor = nameAuthor;
	}

	public String getText(){
		return text;
	}
	public void setText(String text){
		this.text = text;
	}

}
