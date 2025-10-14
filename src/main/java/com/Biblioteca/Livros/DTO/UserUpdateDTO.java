package com.Biblioteca.Livros.DTO;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserUpdateDTO {

        @Pattern(regexp = "^(?!\\s*$).+")
        private String name;

        @Pattern(regexp = "^(?!\\s*$).+")
        private String email;

        @Pattern(regexp = "^(?!\\s*$).+")
        private String numero;

}
