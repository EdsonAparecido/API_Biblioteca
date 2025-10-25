package com.Biblioteca.Livros.Handler;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidHandler(MethodArgumentNotValidException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("Status", HttpStatus.BAD_REQUEST.value());
        response.put("Timestamp", LocalDateTime.now());
        response.put("Mensagem", "Erro de validação nos campos");
        response.put("Erros", ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error-> Map.of("Campo: ", Objects.requireNonNull(error.getField()), "Mensagem: ", error.getDefaultMessage()))
                .collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
