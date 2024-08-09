package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.MenuItemType;

public record DishDto (String nameDish, double priceDish, String dishDescription, MenuItemType menuItens){
}
