package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.ItemType;

public record DrinkDto(String name, double price, String brand, ItemType menuItem) {
}
