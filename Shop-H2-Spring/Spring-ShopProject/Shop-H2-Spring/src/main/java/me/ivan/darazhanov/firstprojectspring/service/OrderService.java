package me.ivan.darazhanov.firstprojectspring.service;

import me.ivan.darazhanov.firstprojectspring.model.Order;
import me.ivan.darazhanov.firstprojectspring.model.Toy;
import me.ivan.darazhanov.firstprojectspring.model.dto.OrderDTO;
import me.ivan.darazhanov.firstprojectspring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ToyService toyService;
    private final UserService userService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ToyService toyService) {
        this.orderRepository = orderRepository;
        this.toyService = toyService;
    }
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public boolean add(OrderDTO orderDTO) {

        if(orderDTO==null) return false;
        Toy toy = toyService.findToyById(orderDTO.getToyId());


    }

}
