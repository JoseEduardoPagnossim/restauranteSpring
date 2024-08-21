package br.com.josepagnossim.restaurant.models.repositories;

import br.com.josepagnossim.restaurant.models.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DishRepository extends JpaRepository<Dish, UUID> {

    List<Dish> findByNameContainingIgnoreCase(@Param("nameDish") String name);



}
