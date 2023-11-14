package com.paulo011.AGA.domain.entities;

import com.paulo011.AGA.domain.constants.Role;

import java.util.List;
import java.util.Objects;

public class User {
    private String cpf;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String house;
    private List<Role> roleList;

    public User() {
    }

    public User(String cpf, String firstName, String lastName, String email, Address address, String house, List<Role> roleList) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.house = house;
        this.roleList = roleList;
    }

    public String getCpf() {
        return cpf;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(cpf, user.cpf) && Objects.equals(address, user.address) && Objects.equals(house, user.house) && Objects.equals(roleList, user.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, cpf, address, house, roleList);
    }
}
