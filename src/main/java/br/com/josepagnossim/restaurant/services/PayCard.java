package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.entities.OrderEntity;
import br.com.josepagnossim.restaurant.models.enums.PaymentType;


public class PayCard implements PaymentProcess {

    @Override
    public void processPayment(OrderEntity order, double amountPaid){
        if(amountPaid != order.getTotalValue()){
            throw new RuntimeException("Amount paid is not equal to total value");
        }
        order.setPaymentMethod(PaymentType.CARD);
    }
}
