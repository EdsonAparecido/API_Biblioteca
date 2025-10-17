package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.DTO.EmprestimoDTO;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Model.Emprestimo;
import com.Biblioteca.Livros.Model.TypeStatus;
import com.Biblioteca.Livros.Model.User;
import com.Biblioteca.Livros.Repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;
    private BookService bookService;
    private UserService userService;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, BookService bookService, UserService userService){
        this.emprestimoRepository = emprestimoRepository;
        this.bookService = bookService;
        this.userService = userService;
    }

    public void emprestarLivro(EmprestimoDTO emprestimoDTO){

        Book book = bookService.readBookById(emprestimoDTO.getBookID())
                .orElseThrow();

        bookService.existBookByStatus(emprestimoDTO.getBookID(), TypeStatus.AVAILABLE)
                .orElseThrow();

        User user = userService.bookIsPresent(emprestimoDTO.getUserID())
                .orElseThrow();

        bookService.updateBookStatus(book);
        userService.updateUserIdBook(emprestimoDTO.getUserID(), book);

        Emprestimo emprestimo = Emprestimo.builder()
                .user(user)
                .book(book)
                .build();

        emprestimoRepository.save(emprestimo);

    }
}
