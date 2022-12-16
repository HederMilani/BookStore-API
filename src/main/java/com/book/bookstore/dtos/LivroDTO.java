package com.book.bookstore.dtos;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.book.bookstore.services.CategoriaService;

public class LivroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService categoriaService;

	private Integer id;
	private String title;
	private String nameAuthor;
	private String text;
	private String categoria;

	public LivroDTO(){
		super();
	}

	public LivroDTO(Integer id, String title, String nameAuthor, String text, Integer idCategoria){
		super();

		this.id = id;
		this.title = title;
		this.nameAuthor = nameAuthor;
		this.text = text;
		this.categoria = categoriaService.findById(idCategoria).getName();
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

	public String getCategoria(){
		return categoria;
	}
	public void setCategoria(Integer categoriaID){
		this.categoria = categoriaService.findById(categoriaID).getName();
	}

}
