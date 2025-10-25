package com.Biblioteca.Livros.DTO.Book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookCreateDTO {

    @NotBlank(message = "Nome é obrigatório e não pode estar vazio")
    @Size(min=1, max=100, message = "Nome precisa conter de 1 a 100 caracteres.")
    private String name;

    @NotBlank(message = "Autor é obrigatório e não pode estar vazio.")
    private String autor;
}
