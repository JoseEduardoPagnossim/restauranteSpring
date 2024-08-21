package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.ComboDto;
import br.com.josepagnossim.restaurant.models.entities.*;
import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.repositories.ComboRepository;
import br.com.josepagnossim.restaurant.models.repositories.DishRepository;
import br.com.josepagnossim.restaurant.models.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComboService {

    private final ComboRepository comboRepository;
    private final DishRepository dishRepository;
    private final DrinkRepository drinkRepository;

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
            // Busca o item cadastrado anteriormente
            Optional<Dish> dish = dishRepository.findById(itemId);
            Optional<Drink> drink = drinkRepository.findById(itemId);

            // Verifica se o item é Dish ou Drink
            ComboItem comboItem = new ComboItem();
            comboItem.setId(UUID.randomUUID()); // Gera um UUID para o ComboItem
            comboItem.setCombo(combo); // Associa o ComboItem ao Combo

            if (dish.isPresent()) {
                Dish dishItem = dish.get();
                comboItem.setMenuItem(ItemType.DISH); // Define como prato
                comboItem.setDescription(dishItem.getName() + " - " + dishItem.getPrice());
                comboItem.setItemId(dishItem.getId()); // Usa o ID do prato

            } else if (drink.isPresent()) {
                Drink drinkItem = drink.get();
                comboItem.setMenuItem(ItemType.DRINK); // Define como bebida
                comboItem.setDescription(drinkItem.getName() + " - " + drinkItem.getPrice());
                comboItem.setItemId(drinkItem.getId()); // Usa o ID da bebida
            } else {
                throw new RuntimeException("Item not found: " + itemId);
            }

            // Adiciona o ComboItem à lista
            comboItems.add(comboItem);
        }

        // Associa os ComboItems ao combo
        combo.setItens(comboItems);

        // Salva o combo no repositório (presumivelmente com um ComboRepository)
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
            comboItem.setMenuItem(itemType);
            comboItem.setMenuItemType(menuItem.getMenuItem());
            comboItem.setCombo(combo);

            comboItems.add(comboItem);
        }

        combo.setItens(comboItems);
        return comboRepository.save(combo);
    }

    public void delete(UUID id) {
        comboRepository.deleteById(id);
    }

}



