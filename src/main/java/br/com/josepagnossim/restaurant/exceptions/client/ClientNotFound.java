package br.com.josepagnossim.restaurant.exceptions.client;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound(String message) {
        super(message);
    }
}

