package com.felipeflohr.uno.exception;

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException() {}

    public InvalidNumberException(String message) {
        super(message);
    }

    public InvalidNumberException(Throwable cause) {
        super(cause);
    }

    public InvalidNumberException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
