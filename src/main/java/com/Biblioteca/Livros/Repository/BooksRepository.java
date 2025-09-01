package com.Biblioteca.Livros.Repository;

import com.Biblioteca.Livros.Model.Books;
import com.Biblioteca.Livros.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Long> {

    Optional<Users> findUsersByBooks(Books books);
}
