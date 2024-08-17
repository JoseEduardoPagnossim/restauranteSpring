package br.com.josepagnossim.restaurant.controllers;

import br.com.josepagnossim.restaurant.models.dtos.ComboDto;
import br.com.josepagnossim.restaurant.models.entities.Combo;
import br.com.josepagnossim.restaurant.services.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/combo")
public class ComboController {

    @Autowired
    ComboService comboService;

    @PostMapping
    public Combo create(@RequestBody ComboDto combodto) {
        return comboService.create(combodto);
    }

    @GetMapping
    public List<Combo> findAll() {
        return comboService.findAll();
    }

    @GetMapping("/{id}")
    public Combo findById(@PathVariable UUID id) {
        return comboService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Combo> findByName(@PathVariable String name) {
        return comboService.findByName(name);
    }

    @PutMapping("/{/id}")
    public Combo update(@PathVariable UUID id, @RequestBody ComboDto combodto) {
        return comboService.updateCombo(id, combodto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        comboService.delete(id);
        return ResponseEntity.ok("Combo Deleted");
    }
}
