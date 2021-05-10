package ru.pizza.pizzastore.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pizza.pizzastore.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByPopular(boolean isPopular, Pageable pageable);
    Page<Product> findByNameContaining(String name, Pageable pageable);

    List<Product> findByNameContaining(String title, Sort sort);
}
