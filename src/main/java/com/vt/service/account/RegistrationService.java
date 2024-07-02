package com.vt.service.account;

import com.vt.model.User;
import com.vt.repository.account.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean isUserExists(String username, String email) {
        return userRepository.findByUsername(username) != null || userRepository.findByEmail(email) != null;
    }

    public boolean registerUser(User user) {
        if (isUserExists(user.getUsername(), user.getEmail())) {
            return false; // Đăng ký thất bại nếu người dùng đã tồn tại
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // Mã hóa mật khẩu
        user.setRole("USER"); // Thiết lập vai trò mặc định là "USER"

        userRepository.save(user); // Lưu người dùng vào cơ sở dữ liệu (userId sẽ được tạo tự động)
        return true; // Đăng ký thành công
    }
}