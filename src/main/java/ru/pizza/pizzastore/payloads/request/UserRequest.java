package ru.pizza.pizzastore.payloads.request;

import ru.pizza.pizzastore.models.ECity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {
    @Size(max = 64)
    private String firstName;

    @Size(max = 128)
    private String lastName;

    @Size(max = 64)
    private String email;

    @Enumerated(EnumType.STRING)
    private ECity city;

    @Size(max = 64)
    private String deliveryAddress;

    @Size(max = 64)
    private String entrance;

    @Size(max = 64)
    private String floor;

    @Size(max = 64)
    private String intercom;

    @Size(max = 64)
    private String tel;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ECity getCity() {
        return city;
    }

    public void setCity(ECity city) {
        this.city = city;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getIntercom() {
        return intercom;
    }

    public void setIntercom(String intercom) {
        this.intercom = intercom;
    }
}
