package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.DishCategory;

public record DishDto (String name, double price, DishCategory dishCategory){
}
