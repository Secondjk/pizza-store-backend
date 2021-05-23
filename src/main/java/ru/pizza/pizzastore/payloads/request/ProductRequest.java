package ru.pizza.pizzastore.payloads.request;

import ru.pizza.pizzastore.models.ProductType;

import javax.validation.constraints.NotBlank;

public class ProductRequest {
    @NotBlank
    private String name;

    @NotBlank
    private Double price;

    @NotBlank
    private String image;

    @NotBlank
    private String description;

    @NotBlank
    private ProductType productType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductRequest() {
    }
}
