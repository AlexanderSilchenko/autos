package com.example.autos.model;

public class Car {
    private String model;
    private int year;
    private int userId;

    public Car() {
    }

    public Car(String model, int year, int userId) {
        this.model = model;
        this.year = year;
        this.userId = userId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getUserId() {
        return userId;
    }
}
