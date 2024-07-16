package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.MenuItem;

public record DrinkDto(String nameDrink, double priceDrink, String brand, MenuItem menuItem) {
}
