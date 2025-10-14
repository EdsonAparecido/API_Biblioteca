package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.DTO.BookCreateDTO;
import com.Biblioteca.Livros.DTO.BookUpdateDTO;
import com.Biblioteca.Livros.Mapper.BookMapper;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@Service
public class BookService {

    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void createBook(BookCreateDTO bookCreateDTO){
        Book book = BookMapper.DTOCreateToBook(bookCreateDTO);
        bookRepository.save(book);
    }

    public List<Book> readBook(){
        return bookRepository.findAll();
    }
    public Optional<Book> readBookById(Long id){
        return bookRepository.findById(id);
    }

    public void updateBook(Long id, BookUpdateDTO bookUpdateDTO){
        Book book = BookMapper.DTOUpdateToBook(bookUpdateDTO);
        Book idBook = bookRepository.findById(id)
                .orElseThrow();
        Book bookUpdate = Book.builder()
                .id(id)
                .name(hasText(book.getName()) ? bookUpdateDTO.getName() : idBook.getName())
                .autor(hasText(book.getAutor()) ? bookUpdateDTO.getAutor() : idBook.getAutor())
                .build();
        bookRepository.save(bookUpdate);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
