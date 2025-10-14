package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> readBook(){
        return bookRepository.findAll();
    }
    public Optional<Book> readBookById(Long id){
        return bookRepository.findById(id);
    }

    public void updateBook(Long id, Book book){
        Book idBook = bookRepository.findById(id)
                .orElseThrow();
        Book bookUpdate = Book.builder()
                .id(id)
                .name(book.getName() != null ? book.getName() : idBook.getName())
                .autor(book.getAutor() != null ? book.getAutor() : idBook.getAutor())
                .build();
        bookRepository.save(bookUpdate);
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

}
