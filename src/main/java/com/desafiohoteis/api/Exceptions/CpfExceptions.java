package com.desafiohoteis.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CpfExceptions extends RuntimeException {
    public CpfExceptions(String message){
        super(message);
    }
}
