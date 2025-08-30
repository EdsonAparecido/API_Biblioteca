package com.Biblioteca.Livros.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_Livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String autor;

    @OneToOne(mappedBy = "livro")
    private Users users;
}
