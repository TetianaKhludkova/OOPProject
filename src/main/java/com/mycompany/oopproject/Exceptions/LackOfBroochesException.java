package com.mycompany.oopproject.Exceptions;

public class LackOfBroochesException extends Exception {

    public LackOfBroochesException() {
        super("Not enough brooches exception");
    }

    public LackOfBroochesException(String message) {
        super(message);
    }

}
