package br.com.josepagnossim.restaurant.models.repositories;

import br.com.josepagnossim.restaurant.models.entities.PaymentMethod;
import br.com.josepagnossim.restaurant.models.enums.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentMethodRepositiry extends JpaRepository<PaymentMethod, UUID> {
    Optional<PaymentMethod> findByType(PaymentType type);
}
