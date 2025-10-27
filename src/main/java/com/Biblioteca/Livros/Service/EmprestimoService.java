package com.Biblioteca.Livros.Service;

import com.Biblioteca.Livros.DTO.EmprestimoDTO;
import com.Biblioteca.Livros.Exceptions.*;
import com.Biblioteca.Livros.Model.Book;
import com.Biblioteca.Livros.Model.Emprestimo;
import com.Biblioteca.Livros.Model.Enum.TypeStatusBook;
import com.Biblioteca.Livros.Model.User;
import com.Biblioteca.Livros.Repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public void createEmprestimo(Emprestimo emprestimo){
        emprestimoRepository.save(emprestimo);
    }
    public Optional<Emprestimo> searchByBookAndDevolucaoIsNull(Book book){
        return emprestimoRepository.findByBookAndDataDevolucaoIsNull(book);
    }

    public void emprestarLivro(EmprestimoDTO emprestimoDTO){
        Book book = bookService.readBookById(emprestimoDTO.getBookID())
                .orElseThrow(() -> new IdNotExists("Não existe livro com o id: " + emprestimoDTO.getBookID()));

        bookService.existBookAndStatus(emprestimoDTO.getBookID(), TypeStatusBook.AVAILABLE)
                .orElseThrow(BookNotAvailable::new);

        userService.readUserById(emprestimoDTO.getUserID())
                .orElseThrow(() -> new IdNotExists("Não existe usuário com o id: " + emprestimoDTO.getUserID()));

        User user = userService.UserNotHaveABook(emprestimoDTO.getUserID())
                .orElseThrow(UserHaveAbook::new);

        bookService.updateBookStatus(book, TypeStatusBook.NOT_AVAILABLE);
        userService.updateUserIdBook(emprestimoDTO.getUserID(), book);

        Emprestimo emprestimo = Emprestimo.builder()
                .user(user)
                .book(book)
                .dataEmprestimo(LocalDateTime.now())
                .build();

        createEmprestimo(emprestimo);
    }


    public void devolverLivro(EmprestimoDTO emprestimoDTO){
        Book book = bookService.readBookById(emprestimoDTO.getBookID())
                .orElseThrow(() -> new IdNotExists("Não existe livro com o id: " + emprestimoDTO.getBookID()));

        User user = userService.readUserById(emprestimoDTO.getUserID())
                .orElseThrow(() -> new IdNotExists("Não existe usuário com o id: " + emprestimoDTO.getUserID()));

        userService.existsBookReadByIdUser(emprestimoDTO.getUserID(), book)
                .orElseThrow(UserDontBook::new);

        Emprestimo emprestimoSearch = searchByBookAndDevolucaoIsNull(book)
                .orElseThrow(BookReturned::new);

        Emprestimo emprestimo = Emprestimo.builder()
                .id(emprestimoSearch.getId())
                .user(emprestimoSearch.getUser())
                .book(emprestimoSearch.getBook())
                .dataEmprestimo(emprestimoSearch.getDataEmprestimo())
                .dataDevolucao(LocalDateTime.now())
                .build();

        bookService.updateBookStatus(book, TypeStatusBook.AVAILABLE);
        userService.updateUserIdBook(emprestimoDTO.getUserID(), null);
        createEmprestimo(emprestimo);
    }

}
