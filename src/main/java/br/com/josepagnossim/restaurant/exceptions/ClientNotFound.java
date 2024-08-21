package br.com.josepagnossim.restaurant.exceptions;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound(String message) {
        super(message);
    }
}

