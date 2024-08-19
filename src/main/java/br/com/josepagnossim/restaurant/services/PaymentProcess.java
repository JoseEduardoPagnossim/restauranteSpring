package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.entities.OrderEntity;

public interface PaymentProcess {

    void processPayment(OrderEntity order, double amoutPaid);
}
