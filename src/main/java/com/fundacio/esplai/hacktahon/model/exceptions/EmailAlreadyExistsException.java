package com.fundacio.esplai.hacktahon.model.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
