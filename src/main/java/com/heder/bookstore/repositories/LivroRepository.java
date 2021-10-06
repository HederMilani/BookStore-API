package com.heder.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heder.bookstore.domain.*;
//Anotação para  que a classe saiba que se trata de uma clase repository
@Repository

public interface LivroRepository extends JpaRepository<Categoria, Integer>{ //primeiro argumento é a classe que seráq implementada; Segundo tipo primitivo de dado do id 

}