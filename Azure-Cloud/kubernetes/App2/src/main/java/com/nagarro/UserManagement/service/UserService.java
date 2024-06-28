package com.nagarro.UserManagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nagarro.UserManagement.model.User;

@Service
public class UserService {

	private final Map<Integer, User> userMap = new HashMap<>();
    private int currentId = 1;
    
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(int id) {
        return userMap.get(id);
    }

    public User addUser(User user) {
        user.setId(currentId++);
        userMap.put(user.getId(), user);
        return user;
    }

    public User updateUser(int id, User user) {
    	userMap.computeIfPresent(id, (key, existingUser) -> {
            user.setId(id);
            return user;
        });

        return userMap.get(id);
    }

    public boolean deleteUser(int id) {
        return userMap.remove(id) != null;
    }

}
