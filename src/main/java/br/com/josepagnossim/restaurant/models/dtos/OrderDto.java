package br.com.josepagnossim.restaurant.models.dtos;

import br.com.josepagnossim.restaurant.models.entities.OrderItem;

import java.util.List;
import java.util.UUID;

public record OrderDto(UUID clientId, List<OrderItemDto> items){
    public record OrderItemDto(UUID itemId, int quantity,double value, double discount){}
}
