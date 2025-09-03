package com.Biblioteca.Livros.Mapper;

import com.Biblioteca.Livros.Model.Books;
import jakarta.persistence.Column;

public class BooksMapper {

    public static Books booksUpdated(Books booksUpdated, Books booksUpdate){
        if (booksUpdate.getName() != null){
            booksUpdated.setName(booksUpdate.getName());
        }
        if (booksUpdate.getAutor() != null){
            booksUpdated.setAutor(booksUpdate.getAutor());
        }
        return booksUpdated;
    }
}
