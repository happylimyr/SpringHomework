package com.epam.spring.boot.SpringHomework4Web.exception;

import com.epam.spring.boot.SpringHomework4Web.model.enums.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    private ErrorType errorType;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ErrorType getErrorType(){
        return ErrorType.FATAL_ERROR_TYPE;
    }
}

