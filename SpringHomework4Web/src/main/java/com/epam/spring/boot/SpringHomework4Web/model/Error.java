package com.epam.spring.boot.SpringHomework4Web.model;

import com.epam.spring.boot.SpringHomework4Web.model.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {

    private String massage;
    private ErrorType errorType;
    private LocalDateTime timeStamp;
}

