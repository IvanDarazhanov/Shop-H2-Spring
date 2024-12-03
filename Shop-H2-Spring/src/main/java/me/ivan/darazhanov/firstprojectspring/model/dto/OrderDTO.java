package me.ivan.darazhanov.firstprojectspring.model.dto;

public class OrderDTO {
    private int userId;
    private int toyId;
    private String orderDate ;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getToyId() {
        return toyId;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
