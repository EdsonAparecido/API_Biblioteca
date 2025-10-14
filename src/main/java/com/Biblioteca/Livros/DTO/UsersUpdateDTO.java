package com.Biblioteca.Livros.DTO;

import com.Biblioteca.Livros.Model.TypeUsers;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsersUpdateDTO {

        @Pattern(regexp = "^(?!\\s*$).+")
        private String name;

        @Pattern(regexp = "^(?!\\s*$).+")
        private String email;

        @Pattern(regexp = "^(?!\\s*$).+")
        private String numero;

}
