package com.paulo011.AGA.domain.entities;

import com.paulo011.AGA.domain.constants.Status;

import java.util.Objects;
import java.util.UUID;

public class Product {
    private UUID code;
    private String name;
    private String description;
    private Double price;
    private Float weight;
    private Float width;
    private Float height;
    private Category category;
    private Status status;

    public Product() {
    }

    public Product(UUID code, String name, String description, Double price, Float weight, Float width, Float height, Category category, Status status) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.category = category;
        this.status = status;
    }

    public UUID getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(weight, product.weight) && Objects.equals(width, product.width) && Objects.equals(height, product.height) && Objects.equals(category, product.category) && Objects.equals(status, product.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, description, price, weight, width, height, category, status);
    }
}
