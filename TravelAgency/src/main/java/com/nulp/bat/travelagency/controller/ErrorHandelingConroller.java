package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.exeption.ServiceException;
import com.nulp.bat.travelagency.model.Error;
import com.nulp.bat.travelagency.model.enums.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@CrossOrigin(origins = "http://localhost:4200")
public class ErrorHandelingConroller {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("handleMethodArgumentNotValidException: message {}", ex.getMessage());
        return ex.getBindingResult().getAllErrors().stream()
                .map(objectError -> new Error(objectError.getDefaultMessage(), ErrorType.VALIDATION_ERROR_TYPE,
                        LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleServiceException(ServiceException ex) {
        log.error("handleServiceException: message {}", ex.getMessage());
        return new Error(ex.getMessage(), ex.getErrorType(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleException(Exception ex) {
        log.error("handleException: message {}", ex.getMessage());
        return new Error(ex.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }

}
