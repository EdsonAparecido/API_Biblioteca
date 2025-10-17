package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.DTO.Book.BookCreateDTO;
import com.Biblioteca.Livros.DTO.Book.BookUpdateDTO;
import com.Biblioteca.Livros.Mapper.BookMapper;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Model.TypeStatus;
import com.Biblioteca.Livros.Model.User;
import com.Biblioteca.Livros.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(BookCreateDTO bookCreateDTO) {
        Book book = BookMapper.DTOCreateToBook(bookCreateDTO);
        bookRepository.save(book);
    }

    public List<Book> readBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> readBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void updateBook(Long id, BookUpdateDTO bookUpdateDTO) {
        Book book = BookMapper.DTOUpdateToBook(bookUpdateDTO);
        Book idBook = bookRepository.findById(id)
                .orElseThrow();
        Book bookUpdate = Book.builder()
                .id(id)
                .name(hasText(book.getName()) ? bookUpdateDTO.getName() : idBook.getName())
                .autor(hasText(book.getAutor()) ? bookUpdateDTO.getAutor() : idBook.getAutor())
                .status(idBook.getStatus())
                .build();
        bookRepository.save(bookUpdate);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public Optional<Boolean> existBookByStatus(Long id, TypeStatus typeStatus){
        return bookRepository.existsByIdAndStatus(id, typeStatus);
    }

    public void updateBookStatus(Book book){
        Book bookUpdateStatus = Book.builder()
                .id(book.getId())
                .name(book.getName())
                .autor(book.getAutor())
                .status(TypeStatus.NOT_AVAILABLE)
                .build();

        bookRepository.save(bookUpdateStatus);
    }
}
