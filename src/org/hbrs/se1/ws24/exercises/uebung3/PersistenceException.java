package org.hbrs.se1.ws24.exercises.uebung3;

import java.io.IOException;

public class PersistenceException extends Exception {

    public enum ExceptionType {
        NoStrategyIsSet,
        ImplementationNotAvailable,
        ConnectionNotAvailable
    }

    private final ExceptionType type;

    public PersistenceException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public PersistenceException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public ExceptionType getType() {
        return type;
    }
}