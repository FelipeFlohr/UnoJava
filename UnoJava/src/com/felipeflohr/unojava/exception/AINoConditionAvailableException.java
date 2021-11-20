package com.felipeflohr.unojava.exception;

/**
 * Exception that represents no valid conditions for the AI
 * @author Felipe Matheus Flohr
 */
public class AINoConditionAvailableException extends RuntimeException {

    public AINoConditionAvailableException() {}

    public AINoConditionAvailableException(String message) {
        super(message);
    }

    public AINoConditionAvailableException(Throwable cause) {
        super(cause);
    }

    public AINoConditionAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
