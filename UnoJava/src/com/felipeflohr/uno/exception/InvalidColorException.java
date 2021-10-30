package com.felipeflohr.uno.exception;

public class InvalidColorException extends Exception {

    public InvalidColorException() {}

    public InvalidColorException(String message) {
        super(message);
    }

    public InvalidColorException(Throwable cause) {
        super(cause);
    }

    public InvalidColorException(String message, Throwable cause) {
        super(message, cause);
    }
}
