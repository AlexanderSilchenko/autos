package com.example.autos.dao;

import com.example.autos.model.Car;
import com.example.autos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAO {
    private static Connection connection;
    @Autowired
    private CarDAO carDAO;

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
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM User";
            ResultSet set = statement.executeQuery(query);
            while(set.next()) {
                int id = set.getInt("id");
                String email = set.getString("email");
                String password = set.getString("password");
                String fullName = set.getString("fullName");
                int age = set.getInt("age");
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setFullName(fullName);
                user.setAge(age);
                user.setCars(carDAO.allUserCars(id));
                //User user = new User(email, password, fullName, age, carDAO.allUserCars(id));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User getUser(int id) {
        try {
            String query = "SELECT * User WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int userId = set.getInt("id");
                String email = set.getString("email");
                String password = set.getString("password");
                String fullName = set.getString("fullname");
                int age = set.getInt("age");
                return new User(email, password, fullName, age, carDAO.allUserCars(userId));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } return null;
    }
}
