package com.app.e_bank.solution.Service;

import com.app.e_bank.solution.Model.Utilisateur;
import com.app.e_bank.solution.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        public List<Utilisateur> getAllUsers() {
            return userRepository.findAll();
        }

        public Utilisateur getUserById(int id) {
            return userRepository.findById(id).get();
        }




    }







