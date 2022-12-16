package com.book.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bookstore.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
