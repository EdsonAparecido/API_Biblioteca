package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.DTO.Book.BookCreateDTO;
import com.Biblioteca.Livros.DTO.Book.BookUpdateDTO;
import com.Biblioteca.Livros.Exceptions.IdNotExists;
import com.Biblioteca.Livros.Mapper.BookMapper;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Model.Enum.TypeStatusBook;
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
                .orElseThrow(() -> new IdNotExists("Não existe livro com o id: " + id));

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
    public Optional<Boolean> existBookAndStatus(Long id, TypeStatusBook typeStatusBook){
        return bookRepository.existsByIdAndStatus(id, typeStatusBook);
    }

    public void updateBookStatus(Book book, TypeStatusBook typeStatusBook){
        Book bookUpdateStatus = Book.builder()
                .id(book.getId())
                .name(book.getName())
                .autor(book.getAutor())
                .status(typeStatusBook)
                .build();

        bookRepository.save(bookUpdateStatus);
    }
}
