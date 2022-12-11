package com.example.autos.dao;

import com.example.autos.model.Car;
import com.example.autos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class CarDAO {
    private static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
        connection = DriverManager.getConnection("jdbc:sqlite:/home/olesia/IdeaProjects/autos/database.db");
        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
    }

    public List<Car> allCars() {
        List<Car> cars = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Car";
            ResultSet set = statement.executeQuery(query);
            while(set.next()) {
                String model = set.getString("model");
                int year = set.getInt("year");
                int userId = set.getInt("userId");
                Car car = new Car(model, year, userId);
                cars.add(car);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    public List<Car> allUserCars(int userId) {
        List<Car> userCars = new ArrayList<>();
        try {
            String query = "SELECT * FROM Car WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                String model = set.getString("model");
                int year = set.getInt("year");
                //int userId = set.getInt("userId");
                Car car = new Car(model, year, userId);
                userCars.add(car);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userCars;
    }
    public Car getCar(int id) {
        try {
            String query = "SELECT * FROM Car WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int carId = set.getInt("id");
                String model = set.getString("model");
                int year = set.getInt("year");
                int userId = set.getInt("userId");
                return new Car(model, year, userId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } return null;
    }
}
