package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.ComboDto;
import br.com.josepagnossim.restaurant.models.entities.Combo;
import br.com.josepagnossim.restaurant.models.entities.ComboItem;
import br.com.josepagnossim.restaurant.models.entities.MenuItens;
import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.enums.MenuItemType;
import br.com.josepagnossim.restaurant.models.repositories.ComboRepository;
import br.com.josepagnossim.restaurant.models.repositories.DishRepository;
import br.com.josepagnossim.restaurant.models.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ComboService {


    private final ComboRepository comboRepository;
    private final DishRepository dishRepository;
    private final DrinkRepository DrinkRepository;

    @Autowired
    public ComboService(ComboRepository comboRepository, DishRepository dishRepository, br.com.josepagnossim.restaurant.models.repositories.DrinkRepository drinkRepository) {
        this.comboRepository = comboRepository;
        this.dishRepository = dishRepository;
        DrinkRepository = drinkRepository;
    }



    public Combo create(ComboDto comboDto){
        Combo combo = new Combo();
        combo.setId(UUID.randomUUID());
        combo.setName(comboDto.name());
        combo.setPrice(comboDto.price());

        List<ComboItem> comboItems = new ArrayList<>();
        for (UUID itemId : comboDto.comboItemIds()) {
            MenuItens menuItens;

            if (comboDto.itemType() == ItemType.DISH) {
                menuItens = dishRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Dish not found: " + itemId));

            } else if (comboDto.itemType() == ItemType.DRINK) {
                menuItens = dishRepository.findById((itemId)).orElseThrow(() -> new RuntimeException("Drink not found: " + itemId));
            } else{
                throw new RuntimeException("Invalid item type: " + comboDto.itemType());
            }
            ComboItem comboItem = new ComboItem();
            comboItems.add(comboItem);
        }
        combo.setItens(comboItems);
        return comboRepository.save(combo);
    }
}



