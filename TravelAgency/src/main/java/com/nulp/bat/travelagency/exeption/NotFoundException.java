package com.nulp.bat.travelagency.exeption;

import com.nulp.bat.travelagency.model.enums.ErrorType;

public class NotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Not found!";

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
