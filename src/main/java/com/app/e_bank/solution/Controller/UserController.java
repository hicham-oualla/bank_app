package com.app.e_bank.solution.Controller;

import com.app.e_bank.solution.Model.Utilisateur;
import com.app.e_bank.solution.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable int id) {
        Utilisateur user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }





}
