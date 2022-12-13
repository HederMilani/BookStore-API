package com.book.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookstore.domain.Categoria;
import com.book.bookstore.domain.Livro;
import com.book.bookstore.repositories.CategoriaRepository;
import com.book.bookstore.repositories.LivroRepository;

@Service
public class DBServices {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados(){
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros Bibliograficos");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis Gerstner", "Loren ipsun", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Welss", "null", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Loren Ipsum", cat2);
		Livro l5 = new Livro(null, "i, Robot", "Isaac Asimov", "Loren ipsm", cat2);

		cat1.getLivtros().addAll(Arrays.asList(l1, l2));
		cat2.getLivtros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
