package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.enums.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodFactory {

    public PaymentProcess getPaymentMethod(PaymentType paymentType) {
        switch (paymentType) {
            case CASH:
                return new PayMoney();
            case CARD:
                return new PayCard();
            case PIX:
                return new PayPix();
            default:
                throw new IllegalArgumentException("Invalid payment method type");
        }
    }
}
