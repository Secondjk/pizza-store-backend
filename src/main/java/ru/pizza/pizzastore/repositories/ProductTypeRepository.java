package ru.pizza.pizzastore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pizza.pizzastore.models.ProductType;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

}
