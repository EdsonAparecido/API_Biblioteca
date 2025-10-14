package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.Model.Books;
import com.Biblioteca.Livros.Repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private BooksRepository booksRepository;
    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public void createBooks(Books books){
        booksRepository.save(books);
    }

    public List<Books> readBooks(){
        return booksRepository.findAll();
    }
    public Optional<Books> readBooksById(Long id){
        return booksRepository.findById(id);
    }

    public void updateBooks(Long id, Books books){
        Books idBooks = booksRepository.findById(id)
                .orElseThrow();
        Books bookUpdate = Books.builder()
                .id(id)
                .name(books.getName() != null ? books.getName() : idBooks.getName())
                .autor(books.getAutor() != null ? books.getAutor() : idBooks.getAutor())
                .build();
        booksRepository.save(bookUpdate);
    }

    public void deleteBooks(Books books){
        booksRepository.delete(books);
    }

}
