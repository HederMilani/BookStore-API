package com.heder.BookStore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//h/ Anotacoes
@Entity	//h/ Informar que classe e uma entidade para que seja criado uma tabela no banco
public class Livro implements Serializable{
	//h/ Criacao de serial
	private static final long serialVersionUID = 1L;
	// h/ Atributos que representam as colunas no banco de dados
	@Id //h/ Anotacao para definir como chave primaria na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) //h/ Anotacao para gerador de id 
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;

	// h/ instanciando foreing key de categoria
	@ManyToOne //h/ Anotacao para fazer vinculo muitos para um
	@JoinColumn(name = "categoria_id") //h/ Anotacao para criar o vinculo com a coluna correta
	private Categoria categoria;

	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
