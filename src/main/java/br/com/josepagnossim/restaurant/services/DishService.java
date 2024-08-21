package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.exceptions.menuitens.IdMenuItemNotFound;
import br.com.josepagnossim.restaurant.models.dtos.DishDto;
import br.com.josepagnossim.restaurant.models.entities.Dish;
import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    private DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish create(DishDto dishDto) {
        Dish dish = new Dish();
        dish.setId(UUID.randomUUID());
        dish.setName(dishDto.name());
        dish.setMenuItemType(ItemType.DISH);
        dish.setDishCategory(dishDto.dishCategory());
        dish.setPrice(dishDto.price());
        return dishRepository.save(dish);
    }

        public List<Dish> findAll(){
            return dishRepository.findAll();
        }

        public Dish findById(UUID id) {
            return dishRepository.findById(id).orElseThrow(() -> new IdMenuItemNotFound("Dish Not Found by ID " + id));
        }

        public List<Dish> findByNameDish(String nameDish){
            return dishRepository.findByNameContainingIgnoreCase(nameDish);
        }

        public Dish update(UUID id, DishDto dishDto) {
            Optional<Dish> optiondish = dishRepository.findById(id);
            if (optiondish.isPresent()) {
                Dish dish = findById(id);
                dish.setName(dishDto.name());
                dish.setPrice(dishDto.price());
                dish.setDishCategory(dishDto.dishCategory());
                return dishRepository.save(dish);
            } else {
                throw new RuntimeException("Dish not found");
            }
        }

        public void delete(UUID id) {
            dishRepository.deleteById(id);
        }
}



