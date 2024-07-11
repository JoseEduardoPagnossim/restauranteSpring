package br.com.josepagnossim.restaurant.models.repositories;

import br.com.josepagnossim.restaurant.models.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DishRepository extends JpaRepository<Dish, UUID> {


}
