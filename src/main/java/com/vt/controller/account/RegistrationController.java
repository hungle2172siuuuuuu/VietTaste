package com.vt.controller.account;

import com.vt.model.Users;
import com.vt.repository.account.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.SecureRandom;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final SecureRandom secureRandom = new SecureRandom(); 

    @GetMapping("/register")
    public String register() {
        return "register"; 
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,
                           Model model) {

        // Kiểm tra xem tên người dùng đã tồn tại chưa
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("errorMessage", "Tên người dùng đã tồn tại.");
            return "register";
        }

        // Tạo userId ngẫu nhiên và đảm bảo duy nhất
        String userId;
        do {
            userId = "#" + generateRandomNumericString(6);
        } while (userRepository.existsById(userId));

        // Tạo đối tượng Users và lưu vào cơ sở dữ liệu
        Users newUser = new Users();
        newUser.setUserId(userId);
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password)); // Mã hóa mật khẩu
        newUser.setEmail(email);
        newUser.setRole("USER");

        userRepository.save(newUser);

        model.addAttribute("successMessage", "Đăng ký thành công!");
        return "register";
    }

    // Hàm tạo chuỗi ngẫu nhiên gồm các chữ số
    private String generateRandomNumericString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomDigit = secureRandom.nextInt(10);
            sb.append(randomDigit);
        }
        return sb.toString();
    }
}
