package com.Biblioteca.Livros.Repository;

import com.Biblioteca.Livros.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
