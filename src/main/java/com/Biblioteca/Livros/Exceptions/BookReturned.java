package com.Biblioteca.Livros.Exceptions;

public class BookReturned extends RuntimeException{

    public BookReturned(){
        super("Book has already been returned");
    }

    public BookReturned(String message){
        super(message);
    }
}