package com.Biblioteca.Livros.Controller;

import com.Biblioteca.Livros.DTO.Book.BookCreateDTO;
import com.Biblioteca.Livros.DTO.Book.BookUpdateDTO;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Home/Book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> newBook(@Valid @RequestBody BookCreateDTO bookCreateDTO){
        bookService.createBook(bookCreateDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Book> readBook(){
        return bookService.readBook();
    }
    @GetMapping("/{id}")
    public Optional<Book> readBookById(@PathVariable Long id){
        return bookService.readBookById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id,@Valid @RequestBody BookUpdateDTO bookUpdateDTO){
        bookService.updateBook(id, bookUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
