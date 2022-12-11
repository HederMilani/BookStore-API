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
}
