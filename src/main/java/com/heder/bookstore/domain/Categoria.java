package com.heder.bookstore.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;

//Anotação para que o sistema já crie uma tabela no banco de dados com esta classe
@Entity

public class Categoria implements Serializable {
	
	//Atributo para serializable
	private static final long serialVersionUID = 1L;
	
	// Atributos conforme consta no banco de dados
	@Id //anotação para definbir id como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	// Atributo para fazer relação conforme DER já compondo uma lista com os livros
	@OneToMany(mappedBy = "caategoria") //Anotação para vinculo entre as classes com mapeamento pelo atributo categoria
	private List<Livro> livro = new ArrayList<>();

	// Métodos contrutores para está super classe
	public Categoria() {
		super();

	}

	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	// Métodos acessores (realizar os acessos aos atributos)
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	// Métodos modificadores (para realizar as modificações nos atributos)
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.descricao = categoria;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	// Método hash code (realiza a comparação do objeto em memória
	public int hasCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
