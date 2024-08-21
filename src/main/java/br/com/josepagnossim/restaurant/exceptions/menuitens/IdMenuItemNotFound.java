package br.com.josepagnossim.restaurant.exceptions.menuitens;

public class IdMenuItemNotFound extends RuntimeException{
    public IdMenuItemNotFound(String message) {
        super(message);
    }
}
