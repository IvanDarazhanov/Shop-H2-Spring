package me.ivan.darazhanov.firstprojectspring.repository;

import me.ivan.darazhanov.firstprojectspring.model.Order;
import me.ivan.darazhanov.firstprojectspring.model.Toy;
import me.ivan.darazhanov.firstprojectspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
