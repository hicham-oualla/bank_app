package com.app.e_bank.solution.Repository;
import com.app.e_bank.solution.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

    }


