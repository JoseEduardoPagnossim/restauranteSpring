package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.DrinkDto;
import br.com.josepagnossim.restaurant.models.entities.Drink;
import br.com.josepagnossim.restaurant.models.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DrinkService {


    final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink create(DrinkDto drinkDto) {
        Drink drink = new Drink();
        drink.setId(UUID.randomUUID());
        drink.setName(drinkDto.nameDrink());
        drink.setMenuItem(drinkDto.menuItem());
        drink.setPrice(drinkDto.priceDrink());
        drink.setBrand(drinkDto.brand());
        return drinkRepository.save(drink);
    }

    public List<Drink> findAll(){
        return drinkRepository.findAll();
    }

    public Drink findById(UUID id) {
        return drinkRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
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
            drink.setName(drinkDto.nameDrink());
            drink.setPrice(drinkDto.priceDrink());
            drink.setBrand(drinkDto.brand());
            return drinkRepository.save(drink);
        } else {
            throw new RuntimeException("Drink not found");
        }
    }

    public void delete(UUID id) {
        Drink drink = findById(id);
        drinkRepository.deleteById(id);
    }





}
