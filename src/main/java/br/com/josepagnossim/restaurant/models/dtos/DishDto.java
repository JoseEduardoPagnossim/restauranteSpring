package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.MenuItem;

public record DishDto (String nameDish, double priceDish, String dishDescription, MenuItem menuItens){
}
