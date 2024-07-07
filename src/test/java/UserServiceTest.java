package com.app.e_bank.solution.Service;

import com.app.e_bank.solution.Model.Utilisateur;
import com.app.e_bank.solution.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        Utilisateur user1 = new Utilisateur();
        user1.setId(1);
        user1.setName("John Doe");

        Utilisateur user2 = new Utilisateur();
        user2.setId(2);
        user2.setName("Jane Smith");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<Utilisateur> users = userService.getAllUsers();

        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("John Doe", users.get(0).getName());
        assertEquals("Jane Smith", users.get(1).getName());
    }

    @Test
    void testGetUserById() {
        Utilisateur user = new Utilisateur();
        user.setId(1);
        user.setName("John Doe");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Utilisateur foundUser = userService.getUserById(1);

        assertNotNull(foundUser);
        assertEquals(1, foundUser.getId());
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testGetUserByIdNotFound() {
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        Utilisateur foundUser = userService.getUserById(1);

        assertNull(foundUser);
    }
}
