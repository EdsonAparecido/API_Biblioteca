package com.Biblioteca.Livros.Mapper;

import com.Biblioteca.Livros.DTO.BookCreateDTO;
import com.Biblioteca.Livros.DTO.BookUpdateDTO;
import com.Biblioteca.Livros.Model.Book;

public class BookMapper {
    public static Book DTOCreateToBook(BookCreateDTO bookCreateDTO){
        return Book.builder()
                .name(bookCreateDTO.getName())
                .autor(bookCreateDTO.getAutor())
                .build();
    }
    public static Book DTOUpdateToBook(BookUpdateDTO bookUpdateDTO){
        return Book.builder()
                .name(bookUpdateDTO.getName())
                .autor(bookUpdateDTO.getAutor())
                .build();
    }
}