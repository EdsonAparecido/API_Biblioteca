package com.Biblioteca.Livros.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false, unique = true)
    double numero;

    @OneToOne
    @JoinColumn(name = "livro")
    private Books books;

    @Enumerated(EnumType.STRING)
    private TypeUsers typeUsers;
}
