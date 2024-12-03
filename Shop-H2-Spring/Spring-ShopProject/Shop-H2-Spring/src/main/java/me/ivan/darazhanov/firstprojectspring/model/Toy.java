package me.ivan.darazhanov.firstprojectspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Toys")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;

    public Toy(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Toy() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
