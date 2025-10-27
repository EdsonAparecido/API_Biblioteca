package com.Biblioteca.Livros.Exceptions;

public class BookNotAvailable extends RuntimeException{

    public BookNotAvailable(){
        super("Book not available");
    }

    public BookNotAvailable(String message){
        super(message);
    }
}
