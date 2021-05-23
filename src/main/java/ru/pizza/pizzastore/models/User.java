package ru.pizza.pizzastore.models;

import ru.pizza.pizzastore.models.Role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        })
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 32)
        private String username;

        @NotBlank
        @Size(max = 64)
        @Email
        private String email;

        @NotBlank
        @Size(max = 128)
        private String password;

        @NotBlank
        @Size(max = 128)
        private String firstName;

        @NotBlank
        @Size(max = 128)
        private String lastName;

        @Enumerated(EnumType.STRING)
        @Column(length = 64)
        private ECity city;

        @Column(name = "delivery_address")
        private String deliveryAddress;

        private String entrance;

        private String floor;

        private String intercom;

        private String tel;

        @ManyToMany
        @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        @ManyToMany
        @JoinTable(name = "user_orders",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "order_id"))
        private Set<Order> orders = new HashSet<>();

        public User(String username, String email, String password, String firstName, String lastName) {
                this.username = username;
                this.email = email;
                this.password = password;
                this.firstName = firstName;
                this.lastName = lastName;
        }

        public User() {}

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Set<Role> getRoles() {
                return roles;
        }

        public void setRoles(Set<Role> roles) {
                this.roles = roles;
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

        public Set<Order> getOrders() {
                return orders;
        }

        public void setOrders(Set<Order> orders) {
                this.orders = orders;
        }
}
