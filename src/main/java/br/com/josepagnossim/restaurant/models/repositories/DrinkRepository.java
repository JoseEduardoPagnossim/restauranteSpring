package br.com.josepagnossim.restaurant.models.repositories;


import br.com.josepagnossim.restaurant.models.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DrinkRepository extends JpaRepository<Drink, UUID> {

}
