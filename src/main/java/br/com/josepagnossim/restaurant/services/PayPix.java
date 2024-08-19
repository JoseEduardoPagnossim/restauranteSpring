package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.entities.OrderEntity;
import br.com.josepagnossim.restaurant.models.enums.PaymentType;


public class PayPix implements PaymentProcess {


    @Override
    public void processPayment(OrderEntity order, double amountPaid) {
        if (amountPaid != order.getTotalValue()) {
            throw new IllegalArgumentException("Payment amount must be equal to the order total for PIX");
        }
        // Adicione lógica específica de PIX aqui se necessário
        order.setPaymentMethod(PaymentType.PIX);
    }
}
