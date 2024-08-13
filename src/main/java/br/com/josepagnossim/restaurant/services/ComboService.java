package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.ComboDto;
import br.com.josepagnossim.restaurant.models.entities.Combo;
import br.com.josepagnossim.restaurant.models.entities.ComboItem;
import br.com.josepagnossim.restaurant.models.repositories.ComboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ComboService {

    @Autowired
    private ComboRepository comboRepository;


    public Combo create(ComboDto comboDto){
        Combo combo = new Combo();
        combo.setName(comboDto.name());

        List<ComboItem> comboItens= new ArrayList<>();
        for (UUID itemId : comboDto.itemId()){

        }

    }


}
