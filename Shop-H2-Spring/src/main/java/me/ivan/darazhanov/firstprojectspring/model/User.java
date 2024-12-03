package me.ivan.darazhanov.firstprojectspring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String fname;
    private String lname;
    @Column( nullable = false)
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    public User(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public User() {}

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void AddOrders(Order order) {
        orders.add(order);
    }
}
