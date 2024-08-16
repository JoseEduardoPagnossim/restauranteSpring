package br.com.josepagnossim.restaurant.controllers;

import br.com.josepagnossim.restaurant.models.dtos.DishDto;
import br.com.josepagnossim.restaurant.models.entities.Dish;
import br.com.josepagnossim.restaurant.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dish")
public class DishController {



    private DishService dishService;

    @PostMapping
    public Dish create(@RequestBody DishDto dishDto) {
        return dishService.create(dishDto);
    }

    @GetMapping
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public Dish findById(@PathVariable UUID id) {
        return dishService.findById(id);
    }

    @GetMapping("/name/{dishName}")
    public List<Dish> findByNameDish(@PathVariable String dishName){
        return dishService.findByNameDish(dishName);
    }

    @PutMapping("/{id}")
    public Dish update(@PathVariable UUID id, @RequestBody DishDto dishDto) {
        return dishService.update(id, dishDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        dishService.delete(id);
        return ResponseEntity.ok("Drink deleted successfully");
    }
}
