package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.Mapper.BooksMapper;
import com.Biblioteca.Livros.Model.Books;
import com.Biblioteca.Livros.Repository.BooksRepository;
import com.Biblioteca.Livros.Repository.UsersRepository;

import java.util.List;

public class AdminService {

    private BooksRepository booksRepository;
    private UsersRepository usersRepository;

    public AdminService(BooksRepository booksRepository){this.booksRepository = booksRepository;}
    public AdminService(UsersRepository usersRepository){this.usersRepository = usersRepository;}

    public Books createBooks(Books books){
        return booksRepository.save(books);
    }
    public List<Books> readBooks(){
        return booksRepository.findAll();
    }

    public Books updateBooks(Long id, Books updateBooks){
        Books updatedBooks = booksRepository.findById(id)
        .orElseThrow();
        updatedBooks = BooksMapper.booksUpdated(updatedBooks, updateBooks);
        return updatedBooks;
    }

    public void deleteBooks(Books books){
        booksRepository.delete(books);
    }
}
