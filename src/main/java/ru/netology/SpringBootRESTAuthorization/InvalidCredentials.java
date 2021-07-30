package ru.netology.SpringBootRESTAuthorization;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidCredentials extends Throwable{

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<String> InvalidCredentials(IllegalArgumentException err) {
        return new ResponseEntity<>("Exception: " + err.getMessage() +
                ", Status: " + HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }
}