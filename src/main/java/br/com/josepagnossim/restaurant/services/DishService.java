package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.DishDto;
import br.com.josepagnossim.restaurant.models.entities.Dish;
import br.com.josepagnossim.restaurant.models.repositories.ComboRepository;
import br.com.josepagnossim.restaurant.models.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DishService {


    private ComboRepository comboRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    private final DishRepository dishRepository;

    public Dish create(DishDto dishDto) {
        Dish dish = new Dish();
        dish.setId(UUID.randomUUID());
        dish.setName(dishDto.nameDish());
        dish.setMenuItem(dishDto.menuItens());
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

        public Dish update(UUID id, DishDto dishDto) {
            Optional<Dish> optionaldish = dishRepository.findById(id);
            if (optionaldish.isPresent()) {
                Dish dish = findById(id);
                dish.setName(dishDto.nameDish());
                dish.setPrice(dishDto.priceDish());
                dish.setMenuItem(dishDto.menuItens());
                return dishRepository.save(dish);
            } else {
                throw new RuntimeException("Dish not found");
            }
        }

        public void delete(UUID id) {
            Dish dish = findById(id);
            dishRepository.deleteById(id);
        }
}



