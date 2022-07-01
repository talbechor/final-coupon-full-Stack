package com.jb.couponsprojectteam.exceptions;

public class AlreadyExistsException extends Exception {

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(ExceptionType exceptionType) {
        super(exceptionType.toString() + " already exists");
    }

}
