package br.com.josepagnossim.restaurant.exceptions.client;

public class InvalidInsertionOfClientData extends RuntimeException {
    public InvalidInsertionOfClientData(String message) {
        super(message);
    }
}
