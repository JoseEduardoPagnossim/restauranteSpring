package br.com.josepagnossim.restaurant.models.repositories;


import br.com.josepagnossim.restaurant.models.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, UUID> {

    //@Query("SELECT c FROM Drink c WHERE LOWER(c.name) LIKE LOWER (CONCAT('%', :drink, '%'))")
    List<Drink> findByNameContainingIgnoreCase(@Param("drink") String drink);

    List<Drink> findByBrandContainingIgnoreCase(@Param("brand") String brand);
}
