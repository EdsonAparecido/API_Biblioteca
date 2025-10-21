package com.Biblioteca.Livros.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Emprestimo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Book book;

    @Column
    private LocalDateTime dataEmprestimo;

    @Column
    private LocalDateTime dataDevolucao;

}
