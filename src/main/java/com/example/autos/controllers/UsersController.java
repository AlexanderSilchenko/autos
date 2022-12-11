package com.example.autos.controllers;

import com.example.autos.dao.UserDAO;
import com.example.autos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserDAO userDAO;

    @GetMapping
    public String allUsers(Model model) {
        List<User> users = userDAO.allUsers();
        model.addAttribute("users", users);
        return "users/index";
    }

}
