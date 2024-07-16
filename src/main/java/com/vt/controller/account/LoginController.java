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

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login"; // Trả về trang login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<Users> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                // Đăng nhập thành công
                model.addAttribute("successMessage", "Đăng nhập thành công!"); // Thêm thông báo thành công
                return "login"; // Trả về lại trang login với thông báo thành công
            }
        }

        // Đăng nhập thất bại
        model.addAttribute("error", true);
        return "login"; 
    }
}
