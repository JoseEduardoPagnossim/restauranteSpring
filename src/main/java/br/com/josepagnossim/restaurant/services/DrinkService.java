package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.exceptions.menuitens.IdMenuItemNotFound;
import br.com.josepagnossim.restaurant.models.dtos.DrinkDto;
import br.com.josepagnossim.restaurant.models.entities.Drink;
import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink create(DrinkDto drinkDto) {
        Drink drink = new Drink();
        drink.setId(UUID.randomUUID());
        drink.setName(drinkDto.name());
        drink.setMenuItemType(ItemType.DRINK);
        drink.setPrice(drinkDto.price());
        drink.setBrand(drinkDto.brand());
        return drinkRepository.save(drink);
    }

    public List<Drink> findAll(){
        return drinkRepository.findAll();
    }

    public Drink findById(UUID id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new IdMenuItemNotFound("Drink Not Found by ID " + id));
    }

    public List<Drink> findByNameDrink(String nameDrink){
        return drinkRepository.findByNameContainingIgnoreCase(nameDrink);
    }

    public List<Drink> findByBrand(String brand){
        return drinkRepository.findByBrandContainingIgnoreCase(brand);
    }

    public Drink update(UUID id, DrinkDto drinkDto) {
        Optional<Drink> optionaldrink = drinkRepository.findById(id);
        if (optionaldrink.isPresent()) {
            Drink drink = findById(id);
            drink.setName(drinkDto.name());
            drink.setPrice(drinkDto.price());
            drink.setBrand(drinkDto.brand());
            return drinkRepository.save(drink);
        } else {
            throw new IdMenuItemNotFound("Drink Not Found for update by ID " + id);
        }
    }

    public void delete(UUID id) {
        drinkRepository.deleteById(id);
    }
}
