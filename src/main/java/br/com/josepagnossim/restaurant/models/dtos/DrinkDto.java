package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.MenuItemType;

public record DrinkDto(String nameDrink, double priceDrink, String brand, MenuItemType menuItem) {
}
