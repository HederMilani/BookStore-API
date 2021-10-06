package com.heder.bookstore.domain;

public class Livro {
	// Atributos conforme consta no banco de dados
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	// Atributo para apresentar a categoria conforme definido no DER
	private Categoria categoria;
	
	// Métodos contrutor para esta super classe
	public Livro() {
		super();
	}
	public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo; 
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}
	
	//Métodos acessores (realizar o acesso aos dados dos atributos)
	public Integer getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public String getTexto() {
		return texto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
	//Métodos Modificadores (Realizam alterações nos atributos desta classe)
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	// Método hash code (realiza a comparação do objeto em memória)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals( Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
