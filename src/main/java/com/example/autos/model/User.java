package com.example.autos.model;

import java.util.List;

public class User {
    private int id;
    private String email;
    private String password;
    private String fullName;
    private int age;
    private List<Car> cars;

    public User() {
    }


    public User(String email, String password, String fullName, int age, List<Car> cars) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.cars = cars;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public List<Car> getCars() {
        return cars;
    }
}
