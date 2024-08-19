package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.enums.PaymentType;

public record PaymentDto(PaymentType paymentType, double amoutPaid) {
    @Override
    public PaymentType paymentType() {
        return paymentType;
    }

    @Override
    public double amoutPaid() {
        return amoutPaid;
    }
}
