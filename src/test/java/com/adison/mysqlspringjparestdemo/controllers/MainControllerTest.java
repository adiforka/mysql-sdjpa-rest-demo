package com.adison.mysqlspringjparestdemo.controllers;

import com.adison.mysqlspringjparestdemo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.adison.mysqlspringjparestdemo.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

class MainControllerTest {

    private MainController controller;

    @Mock
    UserRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new MainController(repository);
    }

    //in progress, maybe in perpetuity
    @Test
    void testMockMVC() throws Exception {
        /*MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc
                .perform(request("/demo"))
                .andExpect(status().isOk());*/
    }

    @Test
    void addNewUser() {
        //given
        User newUser = new User();
        newUser.setName("Charlie");
        newUser.setEmail("charlie@gmail.com");

        when(repository.save(any())).thenReturn(newUser);

        //when
        User savedUser = repository.save(newUser);

        //then
        assertEquals("Charlie", savedUser.getName());
        assertEquals("charlie@gmail.com", savedUser.getEmail());
        verify(repository, times(1)).save(any());
    }

    @Test
    void getAllUsers() {
        //given
        Set<User> users = new HashSet<>();

        User newUser1 = new User();
        newUser1.setName("Andy");
        newUser1.setEmail("a@aol.com");

        User newUser2 = new User();
        newUser2.setName("Jessica");
        newUser2.setEmail("j@aol.com");

        users.add(newUser1);
        users.add(newUser2);

        when(repository.findAll()).thenReturn(users);

        //when
        Set<User> foundUsers = (Set<User>)repository.findAll();

        //then
        assertEquals(users.size(), foundUsers.size());
    }
}