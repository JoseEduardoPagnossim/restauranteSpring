package br.com.josepagnossim.restaurant.controllers;

import br.com.josepagnossim.restaurant.models.dtos.ComboDto;
import br.com.josepagnossim.restaurant.models.entities.Combo;
import br.com.josepagnossim.restaurant.services.ComboService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combo")
public class ComboController {

    private ComboService comboService;

    @PostMapping
    public Combo create(@RequestBody ComboDto combodto) {
        return comboService.create(combodto);
    }




}
