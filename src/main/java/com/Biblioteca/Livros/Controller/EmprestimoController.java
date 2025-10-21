package com.Biblioteca.Livros.Controller;

import com.Biblioteca.Livros.DTO.EmprestimoDTO;
import com.Biblioteca.Livros.Service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/Home")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/Emprestimo")
    public ResponseEntity<Void> newEmprestimo(@Valid @RequestBody EmprestimoDTO emprestimoDTO){
        emprestimoService.emprestarLivro(emprestimoDTO);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/Devolucao")
    public ResponseEntity<Void> devolutionEmprestimo(@Valid @RequestBody EmprestimoDTO emprestimoDTO){
        emprestimoService.devolverLivro(emprestimoDTO);
        return ResponseEntity.ok().build();
    }

}
