package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.ComboDto;
import br.com.josepagnossim.restaurant.models.entities.*;
import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.repositories.ComboRepository;
import br.com.josepagnossim.restaurant.models.repositories.DishRepository;
import br.com.josepagnossim.restaurant.models.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComboService {

    private ComboRepository comboRepository;
    private DishRepository dishRepository;
    private DrinkRepository drinkRepository;

    @Autowired
    public ComboService(ComboRepository comboRepository, DishRepository dishRepository, DrinkRepository drinkRepository) {
        this.comboRepository = comboRepository;
        this.dishRepository = dishRepository;
        this.drinkRepository = drinkRepository;
    }

    public Combo create(ComboDto comboDto) {
        // Cria a instância do Combo
        Combo combo = new Combo();
        combo.setId(UUID.randomUUID());
        combo.setName(comboDto.name());
        combo.setPrice(comboDto.price());

        // Lista para armazenar ComboItems
        List<ComboItem> comboItems = new ArrayList<>();

        for (UUID itemId : comboDto.comboItemIds()) {
            // Cria ComboItem com base no tipo de item
            ComboItem comboItem = new ComboItem();
            comboItem.setId(UUID.randomUUID()); // Gera um ID para ComboItem
            comboItem.setItemId(itemId);

            // Identifica o tipo de item e busca o correspondente Dish ou Drink
            Optional<Dish> dish = dishRepository.findById(itemId);
            Optional<Drink> drink = drinkRepository.findById(itemId);

            if (dish.isPresent()) {
                Dish dishItem = dish.get();
                comboItem.setItemType(ItemType.DISH);
                comboItem.setDescription(dishItem.getName() + " - " + dishItem.getPrice());
                comboItem.setMenuItemType(dishItem.getMenuItem());
            } else if (drink.isPresent()) {
                Drink drinkItem = drink.get();
                comboItem.setItemType(ItemType.DRINK);
                comboItem.setDescription(drinkItem.getName() + " - " + drinkItem.getPrice());
                comboItem.setMenuItemType(drinkItem.getMenuItem());
            } else {
                throw new RuntimeException("Item not found: " + itemId);
            }

            // Associa o ComboItem ao Combo
            comboItem.setCombo(combo);
            comboItems.add(comboItem);
        }

        // Associa os ComboItems ao Combo e salva o Combo
        combo.setItens(comboItems);
        return comboRepository.save(combo);
    }

    public List<Combo> findAll() {
        return comboRepository.findAll();
    }

    public Combo findById(UUID id) {
        return comboRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id combo not found: " + id));
    }

    public List<Combo> findByName(String name) {
        return comboRepository.findByNameContainingIgnoreCase(name);
    }

    public Combo updateCombo(UUID id, ComboDto comboDto) {
        Combo combo = findById(id);
        combo.setName(comboDto.name());
        combo.setPrice(comboDto.price());

        List<ComboItem> comboItems = new ArrayList<>();
        for (UUID itemId : comboDto.comboItemIds()) {
            MenuItens menuItem;
            ItemType itemType = comboDto.itemType();

            if (itemType == ItemType.DISH) {
                menuItem = dishRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Dish not found: " + itemId));
            } else if (itemType == ItemType.DRINK) {
                menuItem = drinkRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Drink not found: " + itemId));
            } else {
                throw new RuntimeException("Invalid item type: " + itemType);
            }

            ComboItem comboItem = new ComboItem();
            comboItem.setId(UUID.randomUUID());
            comboItem.setItemId(itemId);
            comboItem.setDescription(menuItem.getName() + " - " + menuItem.getPrice());
            comboItem.setItemType(itemType);
            comboItem.setMenuItemType(menuItem.getMenuItem());
            comboItem.setCombo(combo);

            comboItems.add(comboItem);
        }

        combo.setItens(comboItems);
        return comboRepository.save(combo);
    }

    public void delete(UUID id) {
        if (comboRepository.existsById(id)) {
            comboRepository.deleteById(id);
        } else {
            throw new RuntimeException("Combo not found: " + id);
        }
    }

}



