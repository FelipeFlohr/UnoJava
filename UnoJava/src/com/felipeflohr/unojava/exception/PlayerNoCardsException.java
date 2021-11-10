package com.felipeflohr.unojava.exception;

public class PlayerNoCardsException extends RuntimeException {

    public PlayerNoCardsException() {}

    public PlayerNoCardsException(String message) {
        super(message);
    }

    public PlayerNoCardsException(Throwable cause) {
        super(cause);
    }

    public PlayerNoCardsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
