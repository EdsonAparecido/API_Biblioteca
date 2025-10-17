package com.Biblioteca.Livros.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmprestimoDTO {

    @NotNull
    private Long userID;

    @NotNull
    private Long bookID;
}
