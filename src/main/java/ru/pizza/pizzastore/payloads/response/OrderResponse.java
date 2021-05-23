package ru.pizza.pizzastore.payloads.response;

import java.util.Date;

public class OrderResponse {
    private Long id;
    private Date date;
    private Double totalPrice;

    public OrderResponse(Long id, Date date, Double totalPrice) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
