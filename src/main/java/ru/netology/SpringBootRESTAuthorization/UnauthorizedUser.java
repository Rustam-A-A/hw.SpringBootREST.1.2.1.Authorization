package ru.netology.SpringBootRESTAuthorization;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import java.io.IOException;

@RestControllerAdvice
public class UnauthorizedUser extends RuntimeException {

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> UnauthorizedUser(UnauthorizedUser err) {
        System.out.println("Exception: " + err.getMessage() +
                ", Status: " + HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>("Unknown user " +
                ", Status: " + HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
    }
}