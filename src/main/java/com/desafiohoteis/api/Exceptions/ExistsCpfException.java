package com.desafiohoteis.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistsCpfException extends RuntimeException {
    public ExistsCpfException(String message){
        super(message);
    }
}
