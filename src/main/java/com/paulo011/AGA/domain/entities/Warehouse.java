package com.paulo011.AGA.domain.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Warehouse {
    private UUID id;
    private String name;
    private List<User> userList;
    private List<Product> productList;

    public Warehouse() {
    }

    public Warehouse(UUID id, String name, List<User> userList, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
        this.productList = productList;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(id, warehouse.id) && Objects.equals(name, warehouse.name) && Objects.equals(userList, warehouse.userList) && Objects.equals(productList, warehouse.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userList, productList);
    }
}
