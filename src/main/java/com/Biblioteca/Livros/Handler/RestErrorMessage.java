package com.Biblioteca.Livros.Handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestErrorMessage {
    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime timeStamp;
}
