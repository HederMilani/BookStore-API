package com.heder.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.heder.bookstore.domain.Categoria;
import com.heder.bookstore.domain.Livro;
import com.heder.bookstore.repositories.CategoriaRepository;
import com.heder.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner{
	
	//Instanciar instants para chamar classes repositoryu
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	// Método para implementar o line runner
	@Override
	public void run(String... args) throws Exception {
		//Instanciar objeto para categoria
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		
		//Instanciar objeto para livro
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsum", cat1);
		
		//Instanciar objetos de livros dentro de categoria
		cat1.getLivro().addAll(Arrays.asList(l1));
		
		//Salvar dados através das categorias repositories
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
