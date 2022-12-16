package com.book.bookstore.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.bookstore.domain.Livro;
import com.book.bookstore.services.LivroService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/livro")
public class LivroResource {

	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = service.findById(id);
		//LivroDTO livroDTO = new LivroDTO(livro.getId(), livro.getTitle(), livro.getNameAuthor(), livro.getText(), livro.getCategoria().getId());
		return ResponseEntity.ok().body(livro);
	}

	@GetMapping
	public ResponseEntity<List <Livro>> findAll(){
		List<Livro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro){
		livro = service.create(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(livro);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@Valid @PathVariable Integer id, @RequestBody Livro livro){
		Livro newLivro = service.update(id, livro);
		return ResponseEntity.ok().body(newLivro);
	}
	
}
