package me.ivan.darazhanov.firstprojectspring.service;

import me.ivan.darazhanov.firstprojectspring.model.Order;
import me.ivan.darazhanov.firstprojectspring.model.Toy;
import me.ivan.darazhanov.firstprojectspring.model.User;
import me.ivan.darazhanov.firstprojectspring.model.dto.OrderDTO;
import me.ivan.darazhanov.firstprojectspring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ToyService toyService;
    private final UserService userService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ToyService toyService, UserService userService) {
        this.orderRepository = orderRepository;
        this.toyService = toyService;
        this.userService = userService;
    }
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public boolean add(OrderDTO orderDTO) {

        if(orderDTO==null) return false;
        Toy toy = toyService.findEToyById(orderDTO.getToyId());
        User user = userService.findEUserById(orderDTO.getUserId());

        Order order = new Order();
        order.setToy(toy);
        order.setUser(user);
        order.setDate(orderDTO.getOrderDate());

        user.AddOrders(order);
        return true;
    }

    public OrderDTO findById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) return null;

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setToyId(order.get().getToy().getId());
        orderDTO.setUserId(order.get().getUser().getId());
        orderDTO.setOrderDate(order.get().getDate());
        return orderDTO;
    }

   // public
}
