package com.book.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Campo NOME é Requerido!")
	@Length(min = 3, max = 100, message = "O campo NOME de ve ter entre 3 e 100 caracteres.")
	private String name;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é Requerido!")
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO de ve ter entre 3 e 200 caracteres.")
	private String description;

	@OneToMany(mappedBy = "categoria")
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
