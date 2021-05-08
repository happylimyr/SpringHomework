package com.nulp.bat.travelagency.exeption;

import com.nulp.bat.travelagency.model.enums.ErrorType;

public class PersonalDataNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Personal data not found!";

    public PersonalDataNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PersonalDataNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
