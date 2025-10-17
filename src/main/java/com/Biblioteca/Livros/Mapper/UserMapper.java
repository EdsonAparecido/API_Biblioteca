package com.Biblioteca.Livros.Mapper;

import com.Biblioteca.Livros.DTO.User.UserCreateDTO;
import com.Biblioteca.Livros.DTO.User.UserUpdateDTO;
import com.Biblioteca.Livros.Model.TypeUser;
import com.Biblioteca.Livros.Model.User;

public class UserMapper {
    public static User DTOCreateToUser(UserCreateDTO userCreateDTO){
        return User.builder()
                .name(userCreateDTO.getName())
                .email(userCreateDTO.getEmail())
                .numero(userCreateDTO.getNumero())
                .typeUser(userCreateDTO.getTypeUser() != null ? userCreateDTO.getTypeUser() : TypeUser.USER)
                .build();
    }
    public static User DTOUpdateToUser(UserUpdateDTO userUpdateDTO){
        return User.builder()
                .name(userUpdateDTO.getName())
                .email(userUpdateDTO.getEmail())
                .numero(userUpdateDTO.getNumero())
                .build();
    }
}
