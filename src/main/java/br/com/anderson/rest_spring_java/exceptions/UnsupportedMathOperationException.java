package br.com.anderson.rest_spring_java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{

    public UnsupportedMathOperationException(String ex) {
        throw new UnsupportedOperationException("Please set a numeric value!");
    }

}