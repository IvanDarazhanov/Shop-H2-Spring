package me.ivan.darazhanov.firstprojectspring.repository;

import me.ivan.darazhanov.firstprojectspring.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {

}
