package com.vt.repository.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.Users;

@Repository
public interface UserDAO extends JpaRepository<Users, String> {
    Optional<Users> findByUsername(String username);  
    Users findByUsernameAndPassword(String username, String password);  
}
