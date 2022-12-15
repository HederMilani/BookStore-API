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

	public Livro create(Livro livro){
		livro.setId(null);
		return repository.save(livro);
	}

	public Livro update(Integer id, Livro obj){
		Livro livro = findById(id);
		livro.setTitle(obj.getTitle());
		livro.setNameAuthor(obj.getNameAuthor());
		livro.setText(obj.getText());
		livro.setCategoria(obj.getCategoria());
		return repository.save(livro);
	}

	public void deletar(Integer id){
		findById(id);
		repository.deleteById(id);
	}
	
}
