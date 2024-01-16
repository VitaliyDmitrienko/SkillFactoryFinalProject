package org.example.exception;

public class WrongInputMoneyDataFormatException extends RuntimeException {
    public WrongInputMoneyDataFormatException (String msg) {
        super(msg);
    }

}
