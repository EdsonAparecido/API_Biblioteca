package com.Biblioteca.Livros.Exceptions;

public class UserDontBook extends RuntimeException{

    public UserDontBook(){
        super("User does not have this book");
    }

    public UserDontBook(String message){
        super(message);
    }
}
