package br.com.josepagnossim.restaurant.controllers;

import br.com.josepagnossim.restaurant.models.dtos.OrderDto;
import br.com.josepagnossim.restaurant.models.entities.OrderEntity;
import br.com.josepagnossim.restaurant.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto);
    }
}
