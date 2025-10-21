package org.zoo.exceptions;

public class CageFullException extends RuntimeException {
    public CageFullException(String message) {
        super(message);
    }
}