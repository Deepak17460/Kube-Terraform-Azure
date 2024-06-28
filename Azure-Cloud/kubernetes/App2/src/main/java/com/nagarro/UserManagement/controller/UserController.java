package com.nagarro.UserManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.UserManagement.model.User;
import com.nagarro.UserManagement.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user")
    public String getUserById(@RequestParam int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email) {
    	
        User user = new User(0, name, email);
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/updateUser")
    public String updateUserForm(@RequestParam int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam int id, @RequestParam String name, @RequestParam String email) {
        User user = new User(id, name, email);
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int id) {
    	boolean deleted = userService.deleteUser(id);
    	if (deleted) {
            return "redirect:/users";
        } else {
            // Handle deletion failure
            return "redirect:/error"; // Redirect to an error page
        }
    }
    
    @GetMapping("/error")
    public String showErrorPage() {
        return "error";
    }
}