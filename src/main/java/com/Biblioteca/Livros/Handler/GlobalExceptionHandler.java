package com.Biblioteca.Livros.Handler;

import com.Biblioteca.Livros.Exceptions.*;
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

    @ExceptionHandler(IdNotExists.class)
    public ResponseEntity<RestErrorMessage> idNotExistsHandler(IdNotExists ex){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }
    @ExceptionHandler(BookNotAvailable.class)
    public ResponseEntity<RestErrorMessage> BookNotAvailableHandler (BookNotAvailable ex){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT,ex.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }
    @ExceptionHandler(UserHaveAbook.class)
    public ResponseEntity<RestErrorMessage> UserHaveAbookHandler (UserHaveAbook ex){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT,ex.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }
    @ExceptionHandler(UserDontBook.class)
    public ResponseEntity<RestErrorMessage> UserDontBookHandler (UserDontBook ex){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT,ex.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }
    @ExceptionHandler(BookReturned.class)
    public ResponseEntity<RestErrorMessage> BookReturnedHandler (BookReturned ex){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT,ex.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }

    /*
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationExceptionHandler(ConstraintViolationException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("Status", HttpStatus.BAD_REQUEST.value());
        response.put("Timestamp", LocalDateTime.now());
        response.put("Mensagem", "Erro de validação nos campos");
        response.put("Erros", ex.getConstraintViolations()
                .stream()
                .map(error-> Map.of("Campo: ", error.getPropertyPath().toString(), "Mensagem: ", error.getMessage()))
                .collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }*/
}
