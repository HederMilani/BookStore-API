package com.heder.BookStore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//h/ Anotacoes
@Entity	//h/ Informar que classe e uma entidade para que seja criado uma tabela no banco
public class Categoria implements Serializable{
	//h/ Criacao de serial
	private static final long serialVersionUID = 1L;
	// h/ Atributos que representam as colunas no banco de dados
	@Id //h/ Anotacao para definir como chave primaria na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) //h/ Anotacao para gerador de id 
	private Integer id;
	private String nome;
	private String descricao;

	// h/ instanciando relaço entre tabelas
	@OneToMany(mappedBy = "categoria") //h/ Anotacao para fazer vinculo e mapear livros que possuem tal categoria
	private List<Livro> livros = new ArrayList<>();

	// h/ Metodo construtor da super classe sem parametros
	public Categoria() {
		super();
	}

	// h/ MNetodo construtor da super classe com os parametros
	public Categoria(Integer id, String nome, String descricao) {
		super();
		// h/ passar parametros para atributos da classe
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	// h/ Metodos de acesso aos dados
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	// h/ Metodos de gravação dos dados
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// h/ Metodo para fazer a comparação com objeto de memoria
	@Override
	public boolean equals(Object obj) {
		// h/ verifica se objeto é igual a este
		if (this == obj) {
			return true;
		}
		// h/ Verifica se objeto é igual a nulo
		if (obj == null) {
			return false;
		}
		// h/ verifica se objeto é diferente da classe
		if (getClass() != obj.getClass()) {
			return false;
		}

		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
