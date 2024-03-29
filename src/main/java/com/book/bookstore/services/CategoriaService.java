package com.book.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.book.bookstore.domain.Categoria;
import com.book.bookstore.dtos.CategoriaDTO;
import com.book.bookstore.repositories.CategoriaRepository;
import com.book.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id){
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj){
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO){
		Categoria obj = findById(id);
		obj.setName(objDTO.getName());
		obj.setDescription(objDTO.getDescription());
		return repository.save(obj);
	}

	public void delete(Integer id){
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.book.bookstore.services.exceptions.DataIntegrityViolationException("Categoria não pode ser Deletada! Possui livros associados.");
		}
	}
}
