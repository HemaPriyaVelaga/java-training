package com.target.java.training.assignments.assignment17.model;

public class InvalidYearException extends Exception {
    public InvalidYearException() {
    }

    public InvalidYearException(String message) {
        super(message);
        System.out.println(message);
    }

    public InvalidYearException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message);
        System.out.println(cause);
    }
}
