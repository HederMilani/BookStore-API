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

	//Hash de verificação
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if(id == null){
			if(other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
