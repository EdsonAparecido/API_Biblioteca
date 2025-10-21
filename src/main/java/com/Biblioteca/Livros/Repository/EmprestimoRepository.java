package com.Biblioteca.Livros.Repository;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Model.Emprestimo;
import com.Biblioteca.Livros.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
    Optional<Emprestimo> findByBookAndDataDevolucaoIsNull(Book book);
}
