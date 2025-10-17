package com.Biblioteca.Livros.Repository;
import com.Biblioteca.Livros.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndBookIsNull(Long id);
}



