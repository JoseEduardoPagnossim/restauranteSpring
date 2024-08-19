package br.com.josepagnossim.restaurant.controllers;

import br.com.josepagnossim.restaurant.models.dtos.OrderDto;
import br.com.josepagnossim.restaurant.models.dtos.PaymentDto;
import br.com.josepagnossim.restaurant.models.entities.OrderEntity;
import br.com.josepagnossim.restaurant.models.enums.PaymentType;
import br.com.josepagnossim.restaurant.services.ClientService;
import br.com.josepagnossim.restaurant.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto);
    }

    @PostMapping("/{orderId}/pay")
    public ResponseEntity<Void> payOrder(@PathVariable UUID orderId, @RequestParam PaymentDto paymentDto) {
        orderService.pay(orderId, paymentDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<OrderEntity> getAllOrders(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable UUID id){
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@RequestBody UUID orderId, OrderDto orderDto){
        return orderService.update(orderId, orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable UUID id){
        orderService.delete(id);
        return ResponseEntity.ok("Order deleted");
    }
}
