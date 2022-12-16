package com.book.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bookstore.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
	
}
