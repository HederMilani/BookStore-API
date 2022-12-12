package com.book.bookstore.domain;

import java.util.ArrayList;
import java.util.List;


public class Categoria {
	
	private Integer id;
	private String name;
	private String description;

	private List<Livro> livros = new ArrayList<>();

	public Categoria() {
		super();

	}

	public Categoria(Integer id, String name, String description) {
		super();

		this.id = id;
		this.name = name;
		this.description = description;

	}

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}

	public List<Livro> getLivtros(){
		return livros;
	}
	public void setLivro(List<Livro> livros){
		this.livros = livros;
	}
	
}
