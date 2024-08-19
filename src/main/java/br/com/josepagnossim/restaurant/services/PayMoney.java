package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.entities.OrderEntity;


public class PayMoney implements PaymentProcess {


    @Override
    public void processPayment(OrderEntity order, double amountPaid) {
        double orderTotal = order.getTotalValue();
        if (amountPaid < order.getTotalValue()) {
            throw new RuntimeException("Cash payment must be at least the order total");
        }
        double change = amountPaid - orderTotal;
        order.setChange(change);
    }
}
