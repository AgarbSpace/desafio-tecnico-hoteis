package com.desafiohoteis.api.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafiohoteis.api.Exceptions.ExistsCpfException;
import com.desafiohoteis.api.Exceptions.InvalidCpfException;
import com.desafiohoteis.api.Exceptions.NotFoundCpfException;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCpfException(InvalidCpfException ex) {
        ErrorResponse errorResponse = new ErrorResponse("InvalidCpfException", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistsCpfException.class)
    public ResponseEntity<ErrorResponse> handleExistsCpfException(ExistsCpfException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ExistsCpfException", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundCpfException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundCpfException(NotFoundCpfException ex) {
        ErrorResponse errorResponse = new ErrorResponse("ExistsCpfException", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

class ErrorResponse {
    private String type;
    private String message;

    public ErrorResponse(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}