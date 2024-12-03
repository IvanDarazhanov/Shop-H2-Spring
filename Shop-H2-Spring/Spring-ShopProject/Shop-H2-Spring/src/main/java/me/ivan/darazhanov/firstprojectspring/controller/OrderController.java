package me.ivan.darazhanov.firstprojectspring.controller;

import me.ivan.darazhanov.firstprojectspring.model.Order;
import me.ivan.darazhanov.firstprojectspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/add-order/{toyid},{userid}")
    public void addOrder(@PathVariable("toyid") String toyid, @PathVariable("userid") String userid) {

    }
}
