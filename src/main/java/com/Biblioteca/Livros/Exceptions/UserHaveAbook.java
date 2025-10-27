package com.Biblioteca.Livros.Exceptions;

public class UserHaveAbook extends RuntimeException{


    public UserHaveAbook(){
        super("User have a book!");
    }

    public UserHaveAbook(String message){
        super(message);
    }
}
