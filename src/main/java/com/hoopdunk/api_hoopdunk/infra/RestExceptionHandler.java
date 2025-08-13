package com.hoopdunk.api_hoopdunk.infra;

import com.hoopdunk.api_hoopdunk.exceptions.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //
public class RestExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    private ResponseEntity<String> userExistsHandler(UserExistsException exception) {
        //podemos usar o Conlifct 409 para falar que ja existe
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

}
