package com.nagarro.UserManagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nagarro.UserManagement.model.User;

class UserServiceTest {
	 @InjectMocks
	    private UserService userService;

	    @Mock
	    private Map<Integer, User> userMap;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        when(userMap.values()).thenReturn(new ArrayList<>());
	    }

	    @Test
	    void testAddUser() {
	        User user = new User(0, "John Doe", "john@example.com");
	        userService.addUser(user);
	        assertEquals(1, userService.getAllUsers().size());
	        assertEquals(1, user.getId());
	    }

	    @Test
	    void testGetAllUsers() {
	        List<User> users = userService.getAllUsers();
	        assertNotNull(users);
	        assertTrue(users.isEmpty());
	    }

	    @Test
	    void testGetUserById() {
	        User user = new User(1, "John Doe", "john@example.com");
	        userService.addUser(user);
	        User foundUser = userService.getUserById(1);
	        assertEquals("John Doe", foundUser.getName());
	    }

	    @Test
	    void testUpdateUser() {
	        User user = new User(1, "John Doe", "john@example.com");
	        userService.addUser(user);
	        User updatedUser = new User(1, "Jane Doe", "jane@example.com");
	        userService.updateUser(1, updatedUser);
	        User foundUser = userService.getUserById(1);
	        assertEquals("Jane Doe", foundUser.getName());
	    }

	    @Test
	    void testDeleteUser() {
	        User user = new User(1, "John Doe", "john@example.com");
	        userService.addUser(user);
	        userService.deleteUser(1);
	        assertNull(userService.getUserById(1));
	    }
	    @Test
	    void testGetUserByIdWithNonExistentId() {
	        int nonExistentId = 100;
	        User user = userService.getUserById(nonExistentId);
	        assertNull(user, "Getting user with non-existent ID should return null");
	    }
	    @Test
	    void testUpdateUserWithNonExistentId() {
	        // Given
	        int nonExistentId = 100;
	        User newUser = new User(nonExistentId, "Jane Doe", "jane@example.com");

	        // When
	        User updatedUser = userService.updateUser(nonExistentId, newUser);

	        // Then
	        assertNull(updatedUser, "Updating user with non-existent ID should return null");
	    }
}