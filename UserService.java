package com.vt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.vt.model.Users;
import com.vt.repository.account.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@SessionScope
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private Users user;
    private String resetToken;
    private String tokenUsername;

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
    public Optional<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
        private Map<String, String> resetCodes = new HashMap<>();

        public boolean emailExists(String email) {
            return userRepository.findByUsername(email).isPresent();
        }

        public String generateResetCode() {
            Random random = new Random();
            int code = random.nextInt(9999);
            return String.format("%04d", code);
        }

        public void saveResetCode(String email, String code) {
            resetCodes.put(email, code);
        }

        public boolean verifyResetCode(String email, String code) {
            String savedCode = resetCodes.get(email);
            return savedCode != null && savedCode.equals(code);
        }

        public void sendResetCode(String email, String code) {
            // Implement sending email logic here
        	System.out.println("Saving reset code: " + code + " for email: " + email);
            resetCodes.put(email, code);
        }
        public boolean updatePassword(String email, String newPassword) {
            Optional<Users> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()) {
                Users user = userOptional.get();
                System.out.println("Updating password for user: " + user.getUsername());
                user.setPassword(newPassword);
                userRepository.save(user);
                System.out.println("Password updated successfully.");
                return true;
            }
            System.out.println("User not found with email: " + email);
            return false;
        }

}
