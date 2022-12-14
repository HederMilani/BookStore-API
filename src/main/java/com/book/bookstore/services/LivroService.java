package com.book.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookstore.domain.Livro;
import com.book.bookstore.repositories.LivroRepository;
import com.book.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id){
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(){
		return repository.findAll();
	}
	
}
