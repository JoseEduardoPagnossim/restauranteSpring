package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.OrderDto;
import br.com.josepagnossim.restaurant.models.entities.Client;
import br.com.josepagnossim.restaurant.models.entities.OrderEntity;
import br.com.josepagnossim.restaurant.models.entities.OrderItem;
import br.com.josepagnossim.restaurant.models.repositories.ClientRepository;
import br.com.josepagnossim.restaurant.models.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    OrderRepository orderRepository;
    ClientRepository clientRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }


    public OrderEntity create(OrderDto orderDto) {
        OrderEntity order = new OrderEntity();
        order.setId(UUID.randomUUID());

        Client client = clientRepository.findById(orderDto.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found: " + orderDto.clientId()));
        order.setClient(client);

        List<OrderItem> orderItems = orderDto.items().stream().map(itemDto -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(UUID.randomUUID());
            orderItem.setItemId(itemDto.itemId());
            orderItem.setQuantity(itemDto.quantity());
            orderItem.setItemValue(itemDto.value());
            orderItem.setDiscount(itemDto.discount());
            return orderItem;
        }).toList();

        order.setItems(orderItems);
        return orderRepository.save(order);
    }
}
