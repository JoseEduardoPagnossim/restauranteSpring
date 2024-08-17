package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.repositories.Payment;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

import java.util.UUID;

@Enabled
public class PayCard implements Payment {

    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public void pay() {

    }
}
