package ru.pizza.pizzastore.payloads.response;

import ru.pizza.pizzastore.models.ECity;

public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private ECity city;
    private String deliveryAddress;
    private String entrance;
    private String floor;
    private String intercom;
    private String tel;

    public UserResponse(String firstName, String lastName, String email, ECity city, String deliveryAddress,
                        String entrance, String floor, String intercom, String tel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.deliveryAddress = deliveryAddress;
        this.entrance = entrance;
        this.floor = floor;
        this.intercom = intercom;
        this.tel = tel;
    }

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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getIntercom() {
        return intercom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setIntercom(String intercom) {
        this.intercom = intercom;
    }
}
