package com.Biblioteca.Livros.Repository;
import com.Biblioteca.Livros.Model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{ }
