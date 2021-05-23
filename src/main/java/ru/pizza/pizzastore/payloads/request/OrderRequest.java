package ru.pizza.pizzastore.payloads.request;

import javax.validation.constraints.NotBlank;

public class OrderRequest {
    @NotBlank
    private Double totalPrice;

    public OrderRequest() {
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
