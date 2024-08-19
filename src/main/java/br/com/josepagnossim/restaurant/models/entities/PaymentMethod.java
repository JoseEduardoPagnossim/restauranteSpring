package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class PaymentMethod {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    private double amountPaid;
    private Double change;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }
}
