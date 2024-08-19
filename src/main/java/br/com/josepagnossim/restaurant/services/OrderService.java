package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.models.dtos.OrderDto;
import br.com.josepagnossim.restaurant.models.dtos.PaymentDto;
import br.com.josepagnossim.restaurant.models.entities.Client;
import br.com.josepagnossim.restaurant.models.entities.OrderEntity;
import br.com.josepagnossim.restaurant.models.entities.OrderItem;
import br.com.josepagnossim.restaurant.models.entities.PaymentMethod;
import br.com.josepagnossim.restaurant.models.enums.PaymentType;
import br.com.josepagnossim.restaurant.models.repositories.ClientRepository;
import br.com.josepagnossim.restaurant.models.repositories.OrderRepository;
import br.com.josepagnossim.restaurant.models.repositories.PaymentMethodRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final PaymentMethodFactory paymentMethodFactory;
    OrderRepository orderRepository;
    ClientRepository clientRepository;
    PaymentMethodRepositiry paymentMethodRepositiry;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, PaymentMethodFactory paymentMethodFactory) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.paymentMethodFactory = paymentMethodFactory;
    }


    public OrderEntity create(OrderDto orderDto) {
        OrderEntity order = new OrderEntity();
        order.setId(UUID.randomUUID());

        Client client = clientRepository.findById(orderDto.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found: " + orderDto.clientId()));
        order.setClient(client);

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderDto.OrderItemDto itemDto : orderDto.items()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(UUID.randomUUID());
            orderItem.setItemId(itemDto.itemId());
            orderItem.setQuantity(itemDto.quantity());
            orderItem.setItemValue(itemDto.value());
            orderItem.setDiscount(itemDto.discount());
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        return orderRepository.save(order);
    }

    public OrderEntity update(UUID orderId, OrderDto orderDto) {
        // Recupera o pedido existente
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));


        // Atualiza o cliente, se necessário
        Client client = clientRepository.findById(orderDto.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found: " + orderDto.clientId()));
        order.setClient(client);

        // Atualiza os itens do pedido
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderDto.OrderItemDto itemDto : orderDto.items()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(UUID.randomUUID());
            orderItem.setItemId(itemDto.itemId());
            orderItem.setQuantity(itemDto.quantity());
            orderItem.setItemValue(itemDto.value());
            orderItem.setDiscount(itemDto.discount());
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);

        return orderRepository.save(order);
    }

    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public OrderEntity findById(UUID orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
    }

    public void delete(UUID orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
        orderRepository.delete(order);
    }

    public void pay(UUID orderId, PaymentDto paymentDto){
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not founda" + orderId));


        PaymentProcess paymentProcess  = paymentMethodFactory.getPaymentMethod(paymentDto.paymentType());
        paymentProcess.processPayment(order, paymentDto.amoutPaid());

            orderRepository.save(order);
    }


}
