package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.enums.MenuItemType;

import java.util.List;
import java.util.UUID;

public record ComboDto(String name, ItemType itemType, double price, List<UUID> comboItemIds, String description) {
}
