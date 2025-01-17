package br.com.anderson.rest_spring_java.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.anderson.rest_spring_java.exceptions.ExceptionResponse;
import br.com.anderson.rest_spring_java.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(
        Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(
            request.getDescription(false), 
            ex.getMessage(), 
            new Date());
            return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(
        Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(
            request.getDescription(false), 
            ex.getMessage(), 
            new Date());
            return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
