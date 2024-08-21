package br.com.josepagnossim.restaurant.exceptions;

public class InvalidInsertionOfClientData extends RuntimeException {
    public InvalidInsertionOfClientData(String message) {
        super(message);
    }
}
