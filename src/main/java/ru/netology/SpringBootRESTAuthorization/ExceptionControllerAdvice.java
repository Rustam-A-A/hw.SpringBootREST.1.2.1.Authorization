package ru.netology.SpringBootRESTAuthorization;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIAE(IllegalArgumentException err) {
        return new ResponseEntity<>("Exception: " + err.getMessage() +
                ", Status: " + HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRE(RuntimeException err) {
        System.out.println("Exception: " + err.getMessage() +
                ", Status: " + HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>("Unknown user " +
                ", Status: " + HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
    }


}
