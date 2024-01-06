package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public AppErrorMessage resourceNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new AppErrorMessage (-1, ex.getMessage(), new Date());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public AppErrorMessage insufficientBalanceException (InsufficientBalanceException ex, WebRequest request) {
        return new AppErrorMessage(0, ex.getMessage(), new Date());
    }
}