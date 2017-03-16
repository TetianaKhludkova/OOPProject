package com.mycompany.oopproject.Exceptions;

public class TooShortMustachesException extends Exception {

    public TooShortMustachesException() {
        super("Not enough mustashes exception");
    }

    public TooShortMustachesException(String message) {
        super(message);
    }

}
