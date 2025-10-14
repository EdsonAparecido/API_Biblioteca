package com.Biblioteca.Livros.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column
    private LocalDate dataDevolucao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_name")
    private Book book;

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;
}
