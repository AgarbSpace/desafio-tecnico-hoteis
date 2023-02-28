package com.desafiohoteis.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundCpfException extends RuntimeException {
    public NotFoundCpfException(String message) {
        super(message);
    }
}
