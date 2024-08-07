package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.DishDto;
import br.com.josepagnossim.restaurant.models.dtos.DrinkDto;
import br.com.josepagnossim.restaurant.models.entities.Dish;
import br.com.josepagnossim.restaurant.models.entities.Drink;
import br.com.josepagnossim.restaurant.models.repositories.DishRepository;
import br.com.josepagnossim.restaurant.models.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish create(DishDto dishDto) {
        Dish dish = new Dish();
        dish.setId(UUID.randomUUID());
        dish.setName(dishDto.nameDish());
        dish.setMenuItem(dishDto.menuItens());
        dish.setDescription(dishDto.dishDescription());
        dish.setPrice(dishDto.priceDish());
        return dishRepository.save(dish);
    }

        public List<Dish> findAll(){
            return dishRepository.findAll();
        }

        public Dish findById(UUID id) {
            return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        }

        public List<Dish> findByNameDish(String nameDish){
            return dishRepository.findByNameContainingIgnoreCase(nameDish);
        }
//
//        public List<Drink> findByBrand(String brand){
//            return drinkRepository.findByBrandContainingIgnoreCase(brand);
//        }
//
//        public Drink update(UUID id, DrinkDto drinkDto) {
//            Optional<Drink> optionaldrink = drinkRepository.findById(id);
//            if (optionaldrink.isPresent()) {
//                Drink drink = findById(id);
//                drink.setName(drinkDto.nameDrink());
//                drink.setPrice(drinkDto.priceDrink());
//                drink.setBrand(drinkDto.brand());
//                return drinkRepository.save(drink);
//            } else {
//                throw new RuntimeException("Drink not found");
//            }
//        }
//
//        public void delete(UUID id) {
//            Drink drink = findById(id);
//            drinkRepository.deleteById(id);
//        }
//
//
//
//
//
//    }

}

