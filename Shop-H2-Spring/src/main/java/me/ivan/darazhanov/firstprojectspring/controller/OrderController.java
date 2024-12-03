package me.ivan.darazhanov.firstprojectspring.controller;

import me.ivan.darazhanov.firstprojectspring.model.Order;
import me.ivan.darazhanov.firstprojectspring.model.dto.OrderDTO;
import me.ivan.darazhanov.firstprojectspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/list")
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    @PostMapping("/add-order")
    public ResponseEntity<Object> CreateOrder(@RequestBody OrderDTO orderDTO) {
        if(orderService.add(orderDTO)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "invalid data"));
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") int id) {
        OrderDTO orderDTO= orderService.findById(id);
        if(orderDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "invalid data"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> UpdateOrder(@PathVariable("id") int id, @RequestBody OrderDTO orderDTO) {

    }
}
