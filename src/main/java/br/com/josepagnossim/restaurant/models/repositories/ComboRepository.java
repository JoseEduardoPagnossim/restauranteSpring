package br.com.josepagnossim.restaurant.models.repositories;

import br.com.josepagnossim.restaurant.models.entities.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ComboRepository extends JpaRepository<Combo, UUID> {

    List<Combo> findByNameContainingIgnoreCase(String name);
}
