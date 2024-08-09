package br.com.josepagnossim.restaurant.models.repositories;

import br.com.josepagnossim.restaurant.models.entities.Combo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComboRepository extends JpaRepository<Combo, UUID> {
}
