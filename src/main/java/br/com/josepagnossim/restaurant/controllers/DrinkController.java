package br.com.josepagnossim.restaurant.controllers;


import br.com.josepagnossim.restaurant.models.dtos.DrinkDto;
import br.com.josepagnossim.restaurant.models.entities.Drink;
import br.com.josepagnossim.restaurant.services.ClientService;
import br.com.josepagnossim.restaurant.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/drink")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;
    @Autowired
    private ClientService clientService;

    @PostMapping
    public Drink create(@RequestBody DrinkDto drinkdto) {
        return drinkService.create(drinkdto);
    }

    @GetMapping
    public List<Drink> findAll() {
        return drinkService.findAll();
    }

    @GetMapping("/{id}")
    public Drink findById(@PathVariable UUID id) {
        return drinkService.findById(id);
    }

    @GetMapping("/name/{drinkName}")
    public List<Drink> findByDrinkName(@PathVariable String drinkName){
        return drinkService.findByNameDrinkContainingIgnoreCase(drinkName);
    }

    @PutMapping("/{id}")
    public Drink update(@PathVariable UUID id, @RequestBody DrinkDto drinkdto) {
        return drinkService.update(id, drinkdto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        drinkService.delete(id);
        return ResponseEntity.ok("Drink deleted successfully");
    }


}
