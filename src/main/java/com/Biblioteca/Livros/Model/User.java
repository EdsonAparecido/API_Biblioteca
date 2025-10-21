package com.Biblioteca.Livros.Model;

import com.Biblioteca.Livros.Model.Enum.TypeUser;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne
    @JoinColumn
    private Book book;

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;
}
