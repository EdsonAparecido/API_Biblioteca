package com.Biblioteca.Livros.Repository;

import com.Biblioteca.Livros.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
