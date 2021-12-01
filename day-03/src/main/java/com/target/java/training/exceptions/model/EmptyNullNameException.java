package com.target.java.training.exceptions.model;

public class EmptyNullNameException extends RuntimeException {
    public EmptyNullNameException() {
    }

    public EmptyNullNameException(String message) {
        super(message);
        System.out.println(message);
    }

    public EmptyNullNameException(Throwable cause) {
        super(cause);
        System.out.println(cause);
    }
}
