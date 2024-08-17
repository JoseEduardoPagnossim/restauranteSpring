package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.repositories.Payment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class PayPix implements Payment {

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
