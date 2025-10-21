package com.Biblioteca.Livros.Mapper;

import com.Biblioteca.Livros.DTO.Book.BookCreateDTO;
import com.Biblioteca.Livros.DTO.Book.BookUpdateDTO;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Model.Enum.TypeStatusBook;

public class BookMapper {
    public static Book DTOCreateToBook(BookCreateDTO bookCreateDTO){
        return Book.builder()
                .name(bookCreateDTO.getName())
                .autor(bookCreateDTO.getAutor())
                .status(TypeStatusBook.AVAILABLE)
                .build();
    }
    public static Book DTOUpdateToBook(BookUpdateDTO bookUpdateDTO){
        return Book.builder()
                .name(bookUpdateDTO.getName())
                .autor(bookUpdateDTO.getAutor())
                .build();
    }
}