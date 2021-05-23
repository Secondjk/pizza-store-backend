package ru.pizza.pizzastore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pizza.pizzastore.models.Product;
import ru.pizza.pizzastore.repositories.ProductRepository;

import java.util.*;

import static java.util.Map.entry;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    private List<Order> getOrdersBySortParams(String[] sort) {
        List<Order> orders = new ArrayList<>();

        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Order(getSortDirection(sort[1]), sort[0]));
        }

        return orders;
    }

    // products?sort={property},{direction}
    @GetMapping("/products/sorted")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<Order> orders = getOrdersBySortParams(sort);
            List<Product> products = productRepository.findAll(Sort.by(orders));

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Object>> getAllProductsPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort
    ) {
        try {
            List<Order> orders = getOrdersBySortParams(sort);

            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
            Page<Product> pageProducts = name == null
                    ? productRepository.findAll(pagingSort)
                    : productRepository.findByNameContaining(name, pagingSort);

            List<Product> products = pageProducts.getContent();

            Map<String, Object> response = Map.ofEntries(
                entry("tutorials", products),
                entry("currentPage", pageProducts.getNumber()),
                entry("totalItems", pageProducts.getTotalElements()),
                entry("totalPages", pageProducts.getTotalPages())
            );

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Optional<Product> product = productRepository.findById(id);

        return product
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
