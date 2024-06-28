package com.nagarro.UserManagement.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nagarro.UserManagement.model.User;
import com.nagarro.UserManagement.service.UserService;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testAddUser() throws Exception {
        mockMvc.perform(post("/addUser")
                .param("name", "Jane Doe")
                .param("email", "jane@example.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"));

        verify(userService, times(1)).addUser(Mockito.any(User.class));
    }

    @Test
    void testUpdateUser() throws Exception {
        User user = new User(1, "John Doe", "john@example.com");
        when(userService.getUserById(1)).thenReturn(user);

        mockMvc.perform(post("/updateUser")
                .param("id", "1")
                .param("name", "Jane Doe")
                .param("email", "jane@example.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"));

        verify(userService, times(1)).updateUser(Mockito.eq(1), Mockito.any(User.class));
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(get("/deleteUser")
                .param("id", "1"))
                .andExpect(status().is3xxRedirection());

        verify(userService, times(1)).deleteUser(1);
    }

    @Test
    void testDeleteUserFailure() throws Exception {
        int userId = 1;
        when(userService.deleteUser(userId)).thenReturn(false);

        mockMvc.perform(get("/deleteUser")
                .param("id", String.valueOf(userId)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/error"));

        verify(userService, times(1)).deleteUser(userId);
    }
}
