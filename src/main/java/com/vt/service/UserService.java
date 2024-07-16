package com.vt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.vt.model.Users;
import com.vt.repository.account.UserRepository;

@Service
@SessionScope
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private Users user;

    public Users login(String username, String password) {
        user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    public Users register(Users newUser) {
        if (userRepository.findByUsername(newUser.getUsername()) == null) {
            return userRepository.save(newUser);
        } else {
            return null;
        }
    }

    public Users getCurrentUser() {
        return user;
    }

    public void logout() {
        this.user = null;
    }
}
