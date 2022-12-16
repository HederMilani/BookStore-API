package com.book.bookstore.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Campo Titulo é Requerido!")
	@Length(min = 3, max = 100, message = "O campo Titulo de ve ter entre 3 e 100 caracteres.")
	private String title;

	@NotEmpty(message = "Campo Nome do Autor é Requerido!")
	@Length(min = 3, max = 100, message = "O campo Nome do Autor de ve ter entre 3 e 100 caracteres.")
	private String nameAuthor;

	@NotEmpty(message = "Campo Texto é Requerido!")
	@Length(min = 1, max=2000000, message = "O campo Texto deve ter no minino 10 caracteres.")
	private String text;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoria;

	public Livro(){
		super();
	}

	public Livro(Integer id, String title, String nameAuthor, String text, Categoria categoria){
		super();

		this.id = id;
		this.title = title;
		this.nameAuthor = nameAuthor;
		this.text = text;
		this.categoria = categoria;
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

	public Categoria getCategoria(){
		return categoria;
	}
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
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
		Livro other = (Livro) obj;
		if(id == null){
			if(other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
