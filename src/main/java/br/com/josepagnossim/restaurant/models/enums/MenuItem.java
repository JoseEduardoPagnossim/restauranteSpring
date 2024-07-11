package br.com.josepagnossim.restaurant.models.enums;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum MenuItem {
    @Enumerated(EnumType.STRING)
    DRINK,
    MAINDISH,
    DESSERT,
    APPETIZER
}
