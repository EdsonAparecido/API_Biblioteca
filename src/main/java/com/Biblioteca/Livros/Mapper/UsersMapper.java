package com.Biblioteca.Livros.Mapper;

import com.Biblioteca.Livros.DTO.UsersCreateDTO;
import com.Biblioteca.Livros.DTO.UsersUpdateDTO;
import com.Biblioteca.Livros.Model.TypeUsers;
import com.Biblioteca.Livros.Model.Users;

public class UsersMapper {
    public static Users DTOCreateToModel(UsersCreateDTO usersCreateDTO){
        return Users.builder()
                .name(usersCreateDTO.getName())
                .email(usersCreateDTO.getEmail())
                .numero(usersCreateDTO.getNumero())
                .typeUsers(usersCreateDTO.getTypeUsers() != null ? usersCreateDTO.getTypeUsers() : TypeUsers.USER)
                .build();
    }
    public static Users DTOUpdateToModel(UsersUpdateDTO usersUpdateDTO){
        return Users.builder()
                .name(usersUpdateDTO.getName())
                .email(usersUpdateDTO.getEmail())
                .numero(usersUpdateDTO.getNumero())
                .build();
    }
}
