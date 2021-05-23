package ru.pizza.pizzastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pizza.pizzastore.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
