package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.ItemType;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public record ComboDto(String name, String description, double price, ItemType itemType, List<UUID> itemId){
}
