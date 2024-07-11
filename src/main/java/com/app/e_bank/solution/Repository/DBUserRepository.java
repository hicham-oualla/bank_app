package com.app.e_bank.solution.Repository;

import com.app.e_bank.solution.Model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, Integer> {
    public DBUser findByUsername(String username);
}
