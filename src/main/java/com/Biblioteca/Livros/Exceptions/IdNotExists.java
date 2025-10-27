package com.Biblioteca.Livros.Exceptions;

public class IdNotExists extends RuntimeException{

    public IdNotExists(){
        super("id not exist");
    }

    public IdNotExists(String message){
        super(message);
    }
}
